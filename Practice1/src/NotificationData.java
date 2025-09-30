import java.time.LocalDateTime;

public class NotificationData {
    private String notificationID;
    private String messageID;
    private String userID;
    private LocalDateTime createdTime;
    private NotificationStatus status;
    
    public NotificationData(String notificationID, String messageID, String userID, NotificationStatus status) {
        this.notificationID = notificationID;
        this.messageID = messageID;
        this.userID = userID;
        this.createdTime = LocalDateTime.now();
        this.status = status;
    }
    
    public String getNotificationID() {
        return notificationID;
    }
    
    public String getMessageID() {
        return messageID;
    }
    
    public String getUserID() {
        return userID;
    }
    
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
    
    public NotificationStatus getStatus() {
        return status;
    }
    
    public void setStatus(NotificationStatus status) {
        this.status = status;
    }
}
