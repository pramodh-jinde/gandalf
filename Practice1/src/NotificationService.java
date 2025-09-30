import java.util.HashSet;
import java.util.List;

public class NotificationService {
    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    List<String> users;

    public HashSet<Notification> getRegisteredNotification() {
        return registeredNotification;
    }

    public void setRegisteredNotification(HashSet<Notification> registeredNotification) {
        this.registeredNotification = registeredNotification;
    }

    HashSet<Notification> registeredNotification = new HashSet<>();

    public NotificationService(List<Notification> registerNotifications) {
        for (Notification notification : registerNotifications) {
            registeredNotification.add(notification);
        }
    }

    public boolean notifyMessage(Message message) {
        for (String userID : users) {
            User user = UserService.getUser(userID);


        }
        return true;
    }

}
