package assignment3_bridge;

public class SimpleNotification extends Notification {
    public SimpleNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String title, String body) {
        sender.sendMessage(format(title, body));
    }

    private static String format(String title, String body) {
        return "Info: [" + title + "] " + body;
    }
}
