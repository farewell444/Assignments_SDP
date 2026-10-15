package assignment4_facade;

import java.util.Objects;

public class NotificationService {

    public void sendOrderConfirmation(String email, String trackingNumber) {
        Objects.requireNonNull(email, "email must not be null");
        Objects.requireNonNull(trackingNumber, "trackingNumber must not be null");

        System.out.printf("[Notification] Order confirmation sent to %s with tracking %s.%n",
                email, trackingNumber);
    }
}
