package assignment5_strategy;

import java.util.Objects;

public class OrderCalculator {

    private DiscountStrategy discountStrategy;

    public OrderCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = Objects.requireNonNull(discountStrategy, "DiscountStrategy cannot be null");
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = Objects.requireNonNull(discountStrategy, "DiscountStrategy cannot be null");
    }

    public double calculateFinalTotal(double originalAmount) {
        if (originalAmount <= 0) {
            throw new IllegalArgumentException("originalAmount must be greater than zero, but was " + originalAmount);
        }
        return discountStrategy.applyDiscount(originalAmount);
    }
}
