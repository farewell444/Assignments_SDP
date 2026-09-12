package assignment1_builder;

public class PizzaDirector {

    public Pizza makeClassicPizza(PizzaBuilder builder) {
        return builder.reset()
                .build();
    }

    public Pizza makePartyPizza(PizzaBuilder builder) {
        return builder.reset()
                .setTopping("Pepperoni, Sausage, Mushrooms, Onions, Green Peppers")
                .setExtraCheese(true)
                .build();
    }
}
