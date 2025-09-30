import java.util.List;
import java.util.Scanner;

public class Main {
    private static NotificationService notificationService = new NotificationService();
    private static Database database = Database.getInstance();

    public static void main(String[] args) {
        setupDefaultData();
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\nBTC Notification System - Options: 1.Create 2.Send 3.List 4.Remove Email 0.Exit");
            System.out.print("Choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createDefaultNotification();
                    break;
                case 2:
                    sendLatestNotification();
                    break;
                case 3:
                    listAllNotifications();
                    break;
                case 4:
                    removeEmailNotification();
                    break;
                case 0:
                    running = false;
                    break;
            }
        }
        scanner.close();
    }
    
    private static void setupDefaultData() {
        User user1 = new User("user1", "user1@example.com", "1234567890");
        User user2 = new User("user2", "user2@example.com", "0987654321");
        database.saveUser(user1);
        database.saveUser(user2);
        notificationService.addUser(user1.getID());
        notificationService.addUser(user2.getID());
        
        createDefaultNotification();
    }
    
    private static void createDefaultNotification() {
        float currentPrice = 50000.0f;
        float marketVolume = 30000.0f;
        float dayHighPrice = 51000.0f;
        double marketCap = 950.0; 
        
        Message message = notificationService.createBTCNotification(
            currentPrice, marketVolume, dayHighPrice, marketCap * 1_000_000_000);
        
        System.out.println("Created notification: " + message.toString());
    }
    
    private static void sendLatestNotification() {
        List<Message> messages = database.getAllMessages();
        if (messages.isEmpty()) {
            System.out.println("No messages to send");
            return;
        }
        
        Message latestMessage = messages.get(messages.size() - 1);
        boolean success = notificationService.notifyMessage(latestMessage);
        
        System.out.println("Notification sent: " + (success ? "Success" : "Some failures"));
    }
    
    private static void listAllNotifications() {
        List<NotificationData> notifications = notificationService.getAllNotifications();
        
        System.out.println("\nAll Notifications:");
        if (notifications.isEmpty()) {
            System.out.println("No notifications found");
            return;
        }
        
        for (NotificationData notification : notifications) {
            System.out.println(notification.getStatus() + " - " + 
                              notification.getCreatedTime() + " - User: " + 
                              notification.getUserID());
        }
    }
    
    private static void removeEmailNotification() {
        if (notificationService.hasEmailNotification()) {
            notificationService.removeEmailNotification();
            System.out.println("Email notification removed from registry");
        } else {
            System.out.println("No email notification found in registry");
        }
    }
}