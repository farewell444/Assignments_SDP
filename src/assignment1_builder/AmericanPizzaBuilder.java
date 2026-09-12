package assignment1_builder;

public class AmericanPizzaBuilder implements PizzaBuilder {
    private String dough;
    private String sauce;
    private String topping;
    private boolean extraCheese;

    public AmericanPizzaBuilder() {
        this.reset();
    }

    @Override
    public PizzaBuilder reset() {
        this.dough = "Thick Crust";
        this.sauce = "Barbecue";
        this.topping = "Cheddar Cheese, Pepperoni and Bacon";
        this.extraCheese = true;
        return this;
    }

    @Override
    public PizzaBuilder setDough(String dough) {
        this.dough = dough;
        return this;
    }

    @Override
    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    @Override
    public PizzaBuilder setTopping(String topping) {
        this.topping = topping;
        return this;
    }

    @Override
    public PizzaBuilder setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
        return this;
    }

    @Override
    public Pizza build() {
        if (dough == null || dough.isEmpty()) {
            throw new IllegalStateException("Dough cannot be null or empty");
        }
        if (sauce == null || sauce.isEmpty()) {
            throw new IllegalStateException("Sauce cannot be null or empty");
        }
        if (topping == null || topping.isEmpty()) {
            throw new IllegalStateException("Topping cannot be null or empty");
        }
        return new Pizza(dough, sauce, topping, extraCheese);
    }
}

