package assignment4_facade;

import java.util.Objects;

public class OrderProcessingFacade {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderProcessingFacade() {
        this(new InventoryService(), new PaymentService(), new ShippingService(), new NotificationService());
    }

    public OrderProcessingFacade(InventoryService inventoryService, PaymentService paymentService, ShippingService shippingService, NotificationService notificationService) {
        this.inventoryService = Objects.requireNonNull(inventoryService, "inventoryService must not be null");
        this.paymentService = Objects.requireNonNull(paymentService, "paymentService must not be null");
        this.shippingService = Objects.requireNonNull(shippingService, "shippingService must not be null");
        this.notificationService = Objects.requireNonNull(notificationService, "notificationService must not be null");
    }

    public boolean placeOrder(String productId, int quantity, double amount, String email, String address) {
        validateOrder(productId, quantity, amount, email, address);

        if (!isInStock(productId, quantity)) {
            return false;
        }
        inventoryService.reserveStock(productId, quantity);

        if (!chargeCustomer(email, amount)) {
            return false;
        }

        String trackingNumber = shippingService.arrangeShipping(productId, quantity, address);
        notificationService.sendOrderConfirmation(email, trackingNumber);
        return true;
    }

    private static void validateOrder(String productId, int quantity, double amount, String email, String address) {
        requireText(productId, "productId");
        requireText(email, "email");
        requireText(address, "address");
        requirePositive(quantity, "quantity");
        requirePositive(amount, "amount");
    }

    private static void requireText(String value, String name) {
        Objects.requireNonNull(value, name + " must not be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException(name + " must not be blank");
        }
    }

    private static void requirePositive(int value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " must be greater than zero, but was " + value);
        }
    }

    private static void requirePositive(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " must be greater than zero, but was " + value);
        }
    }

    private boolean isInStock(String productId, int quantity) {
        if (inventoryService.checkStock(productId, quantity)) {
            return true;
        }
        System.out.println("[Facade] Order rejected: insufficient stock for " + productId + ".");
        return false;
    }

    private boolean chargeCustomer(String email, double amount) {
        if (paymentService.processPayment(email, amount)) {
            return true;
        }
        System.out.println("[Facade] Order rejected: payment could not be processed.");
        return false;
    }
}
