package assignment5_strategy;

public class BlackFridayStrategy implements DiscountStrategy {

    private static final double DISCOUNT_RATE = 0.50;
    private static final double MULTIPLIER = 1.0 - DISCOUNT_RATE;

    @Override
    public double applyDiscount(double originalAmount) {
        return originalAmount * MULTIPLIER;
    }

    @Override
    public String getStrategyName() {
        return "Black Friday (50%)";
    }
}
