package assignment5_strategy;

public class StudentDiscountStrategy implements DiscountStrategy {

    private static final double DISCOUNT_RATE = 0.15;
    private static final double MULTIPLIER = 1.0 - DISCOUNT_RATE;

    @Override
    public double applyDiscount(double originalAmount) {
        return originalAmount * MULTIPLIER;
    }

    @Override
    public String getStrategyName() {
        return "Student Discount (15%)";
    }
}
