package assignment5_strategy;

public interface DiscountStrategy {

    double applyDiscount(double originalAmount);

    String getStrategyName();
}
