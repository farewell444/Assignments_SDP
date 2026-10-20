package assignment5_strategy;

public class RegularCustomerStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double originalAmount) {
        return originalAmount;
    }

    @Override
    public String getStrategyName() {
        return "Regular Customer (0%)";
    }
}
