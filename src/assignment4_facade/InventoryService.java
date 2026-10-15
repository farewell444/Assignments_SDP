package assignment4_facade;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InventoryService {

    private static final int DEFAULT_STOCK_LEVEL = 5;

    private final Map<String, Integer> stockLevels = new HashMap<>();

    public boolean checkStock(String productId, int quantity) {
        Objects.requireNonNull(productId, "productId must not be null");
        requirePositive(quantity, "quantity");

        int available = availableStock(productId);
        boolean inStock = available >= quantity;
        System.out.printf("[Inventory] Checking stock for %s: requested=%d, available=%d -> %s%n",
                productId, quantity, available, inStock ? "IN STOCK" : "OUT OF STOCK");
        return inStock;
    }

    public void reserveStock(String productId, int quantity) {
        Objects.requireNonNull(productId, "productId must not be null");
        requirePositive(quantity, "quantity");

        stockLevels.put(productId, availableStock(productId) - quantity);
        System.out.printf("[Inventory] Reserved %d unit(s) of %s.%n", quantity, productId);
    }

    private int availableStock(String productId) {
        return stockLevels.getOrDefault(productId, DEFAULT_STOCK_LEVEL);
    }

    private static void requirePositive(int value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " must be greater than zero, but was " + value);
        }
    }
}
