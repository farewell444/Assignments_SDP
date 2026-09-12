package assignment1_builder;

public interface PizzaBuilder {
    PizzaBuilder reset();

    PizzaBuilder setDough(String dough);

    PizzaBuilder setSauce(String sauce);

    PizzaBuilder setTopping(String topping);

    PizzaBuilder setExtraCheese(boolean extraCheese);

    Pizza build();
}
