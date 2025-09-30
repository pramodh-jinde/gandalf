import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class NotificationService {
    private List<String> users;
    private HashSet<Notification> registeredNotifications = new HashSet<>();
    private Database database = Database.getInstance();

    public NotificationService() {
        this.users = new ArrayList<>();
        registeredNotifications.add(new EmailNotification());
    }

    public NotificationService(List<Notification> registerNotifications) {
        this.users = new ArrayList<>();
        for (Notification notification : registerNotifications) {
            registeredNotifications.add(notification);
        }
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public void addUser(String userId) {
        if (!users.contains(userId)) {
            users.add(userId);
        }
    }

    public void addRegisteredNotification(Notification notification) {
        registeredNotifications.add(notification);
    }

    public void removeEmailNotification() {
        registeredNotifications.removeIf(notification -> notification instanceof EmailNotification);
    }

    public boolean hasEmailNotification() {
        return registeredNotifications.stream().anyMatch(notification -> notification instanceof EmailNotification);
    }

    public Message createBTCNotification(float currentPrice, float marketTradeVolume, 
                                        float intraDayHighPrice, double marketCap) {
        Message message = new Message(currentPrice, marketTradeVolume, intraDayHighPrice, marketCap);
        database.saveMessage(message);
        return message;
    }

    public boolean notifyMessage(Message message) {
        boolean allSuccessful = true;
        
        for (String userID : users) {
            User user = database.getUser(userID);
            if (user == null) continue;
            
            boolean userNotified = false;
            
            for (Notification notification : registeredNotifications) {
                String notificationId = UUID.randomUUID().toString();
                NotificationStatus status = notification.notify(user, message);
                
                NotificationData notificationData = new NotificationData(
                    notificationId, message.getID(), user.getID(), status);
                database.saveNotification(notificationData);
                
                if (status == NotificationStatus.SENT) {
                    userNotified = true;
                    break;
                }
            }
            
            if (!userNotified) {
                allSuccessful = false;
            }
        }
        
        return allSuccessful;
    }
    
    public List<NotificationData> getAllNotifications() {
        return database.getAllNotifications();
    }
    
    public List<NotificationData> getNotificationsByStatus(NotificationStatus status) {
        return database.getNotificationsByStatus(status);
    }
}
