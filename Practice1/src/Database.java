import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Database {
    private static final Database instance = new Database();
    
    private final Map<String, NotificationData> notifications = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Message> messages = new HashMap<>();
    
    private Database() {
        User defaultUser = new User("user1", "user@example.com", "1234567890");
        users.put(defaultUser.getID(), defaultUser);
    }
    
    public static Database getInstance() {
        return instance;
    }
    
    public void saveNotification(NotificationData notification) {
        notifications.put(notification.getNotificationID(), notification);
    }
    
    public NotificationData getNotification(String id) {
        return notifications.get(id);
    }
    
    public List<NotificationData> getAllNotifications() {
        return new ArrayList<>(notifications.values());
    }
    
    public List<NotificationData> getNotificationsByStatus(NotificationStatus status) {
        return notifications.values().stream()
                .filter(n -> n.getStatus() == status)
                .collect(Collectors.toList());
    }
    
    public void saveUser(User user) {
        users.put(user.getID(), user);
    }
    
    public User getUser(String id) {
        return users.get(id);
    }
    
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
    
    public void saveMessage(Message message) {
        messages.put(message.getID(), message);
    }
    
    public Message getMessage(String id) {
        return messages.get(id);
    }
    
    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }
}