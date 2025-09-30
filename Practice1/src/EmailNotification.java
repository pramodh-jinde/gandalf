import com.sun.jdi.connect.Transport;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailNotification implements Notification {
    @Override
    public NotificationStatus notify(User user, Message message) {
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", "smtp.myisp.com");
        Session session = Session.getDefaultInstance(props, null);

        // Construct the message
        String to = user.email;
        String from = "notification_service.com";
        String subject = "Hello";
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText("Hi,\n\nHow are you?");

            // Send the message.
            Transport.send(msg);
        } catch (MessagingException e) {
            return NotificationStatus.FAILED;
        }
        return NotificationStatus.SENT;
    }
}
