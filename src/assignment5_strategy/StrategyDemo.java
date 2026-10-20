package assignment5_strategy;

public class StrategyDemo {

    private static final double BASE_ORDER_TOTAL = 200.00;

    public static void main(String[] args) {
        OrderCalculator calculator = new OrderCalculator(new RegularCustomerStrategy());
        printTotal(calculator, "Regular customer");

        calculator.setDiscountStrategy(new StudentDiscountStrategy());
        printTotal(calculator, "Student discount");

        calculator.setDiscountStrategy(new BlackFridayStrategy());
        printTotal(calculator, "Black Friday");

        demonstrateValidation();
    }

    private static void printTotal(OrderCalculator calculator, String scenario) {
        double total = calculator.calculateFinalTotal(BASE_ORDER_TOTAL);
        System.out.printf("%-20s -> $%.2f%n", scenario, total);
    }

    private static void demonstrateValidation() {
        OrderCalculator calculator = new OrderCalculator(new RegularCustomerStrategy());

        try {
            calculator.calculateFinalTotal(0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation caught: " + ex.getMessage());
        }

        try {
            calculator.setDiscountStrategy(null);
        } catch (NullPointerException ex) {
            System.out.println("Validation caught: " + ex.getMessage());
        }
    }
}
