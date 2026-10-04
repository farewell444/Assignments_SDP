package assignment3_bridge;

import java.util.Objects;

public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("[Email] Sent to inbox: " + Objects.requireNonNull(message));
    }
}
