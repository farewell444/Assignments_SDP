package assignment3_bridge;

public class BridgeDemo {
    public static void main(String[] args) {
        Notification simple = new SimpleNotification(new EmailSender());
        simple.send("Welcome", "Thanks for joining our service.");
        simple.setSender(new SmsSender());
        simple.send("Welcome", "Thanks for joining our service.");

        Notification urgent = new UrgentNotification(new SmsSender());
        urgent.send("Server Down", "Main server is unreachable.");
        urgent.setSender(new EmailSender());
        urgent.send("Server Down", "Main server is unreachable.");

        demonstrateValidation();
    }

    private static void demonstrateValidation() {
        try {
            new SimpleNotification(null);
        } catch (NullPointerException ex) {
            System.out.println("Validation caught: " + ex.getMessage());
        }
    }
}
