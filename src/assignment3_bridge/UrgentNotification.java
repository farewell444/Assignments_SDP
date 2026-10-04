package assignment3_bridge;

public class UrgentNotification extends Notification {
    public UrgentNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String title, String body) {
        sender.sendMessage(format(title, body));
    }

    private static String format(String title, String body) {
        return "[ALERT - PRIORITY HIGH] [" + title + "] " + body + " (Immediate action required!)";
    }
}
