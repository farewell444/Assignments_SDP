package assignment4_facade;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ShippingService {

    private static final AtomicInteger TRACKING_SEQUENCE = new AtomicInteger(100_000);

    public String arrangeShipping(String productId, int quantity, String address) {
        Objects.requireNonNull(productId, "productId must not be null");
        Objects.requireNonNull(address, "address must not be null");
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be greater than zero, but was " + quantity);
        }

        String trackingNumber = "TRK-" + TRACKING_SEQUENCE.incrementAndGet();
        System.out.printf("[Shipping] Dispatched %d unit(s) of %s to %s. Tracking: %s%n",
                quantity, productId, address, trackingNumber);
        return trackingNumber;
    }
}
