package assignment3_bridge;

import java.util.Objects;

public abstract class Notification {
    protected MessageSender sender;

    protected Notification(MessageSender sender) {
        this.sender = requireSender(sender);
    }

    public void setSender(MessageSender sender) {
        this.sender = requireSender(sender);
    }

    public abstract void send(String title, String body);

    private static MessageSender requireSender(MessageSender sender) {
        return Objects.requireNonNull(sender, "Sender cannot be null");
    }
}
