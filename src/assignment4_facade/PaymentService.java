package assignment4_facade;

import java.util.Objects;

public class PaymentService {

    public boolean processPayment(String email, double amount) {
        Objects.requireNonNull(email, "email must not be null");
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero, but was " + amount);
        }

        System.out.printf("[Payment] Charged $%.2f to %s.%n", amount, email);
        return true;
    }
}
