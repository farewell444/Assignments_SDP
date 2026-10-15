package assignment4_facade;

public class FacadeDemo {

    public static void main(String[] args) {
        OrderProcessingFacade facade = new OrderProcessingFacade();

        placeSuccessfulOrder(facade);
        handleOutOfStockOrder(facade);
        demonstrateValidation(facade);
    }

    private static void placeSuccessfulOrder(OrderProcessingFacade facade) {
        System.out.println("--- Scenario 1: Successful order ---");
        boolean placed = facade.placeOrder("LAPTOP-PRO", 1, 1299.99, "alice@example.com", "123 Main St, Springfield");
        System.out.println("Order placed: " + placed);
        System.out.println();
    }

    private static void handleOutOfStockOrder(OrderProcessingFacade facade) {
        System.out.println("--- Scenario 2: Out-of-stock order ---");
        boolean placed = facade.placeOrder("LAPTOP-PRO", 50, 64999.50, "bob@example.com", "42 Elm Ave, Shelbyville");
        System.out.println("Order placed: " + placed);
        System.out.println();
    }

    private static void demonstrateValidation(OrderProcessingFacade facade) {
        System.out.println("--- Scenario 3: Invalid input ---");
        try {
            facade.placeOrder("LAPTOP-PRO", 0, 1299.99, "alice@example.com", "123 Main St");
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation caught: " + ex.getMessage());
        }

        try {
            facade.placeOrder("LAPTOP-PRO", 1, 1299.99, null, "123 Main St");
        } catch (NullPointerException ex) {
            System.out.println("Validation caught: " + ex.getMessage());
        }
    }
}
