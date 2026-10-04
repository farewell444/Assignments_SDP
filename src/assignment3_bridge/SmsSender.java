package assignment3_bridge;

import java.util.Objects;

public class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("[SMS] Sent to phone: " + Objects.requireNonNull(message));
    }
}
