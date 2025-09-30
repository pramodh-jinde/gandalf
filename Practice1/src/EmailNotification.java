public class EmailNotification implements Notification {
    @Override
    public NotificationStatus notify(User user, Message message) {
        try {
            System.out.println("Sending email notification to: " + user.getEmail());
            System.out.println("Subject: BTC Market Update");
            System.out.println("Content: " + message.toString());
            System.out.println("Email sent successfully!");
            
            return NotificationStatus.SENT;
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
            return NotificationStatus.FAILED;
        }
    }
}
