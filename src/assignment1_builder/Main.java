package assignment1_builder;

public class Main {
    public static void main(String[] args) {
        PizzaDirector director = new PizzaDirector();

        //сборка через директора
        PizzaBuilder italianBuilder = new ItalianPizzaBuilder();
        Pizza margherita = director.makeClassicPizza(italianBuilder);
        System.out.println(margherita);

        PizzaBuilder americanBuilder = new AmericanPizzaBuilder();
        Pizza partyPizza = director.makePartyPizza(americanBuilder);
        System.out.println(partyPizza);

        //ручная сборка напрямую через цепочку методов
        Pizza customPizza = new ItalianPizzaBuilder()
                .setDough("Gluten-free crust")
                .setSauce("Pesto")
                .setTopping("Olives and Mushrooms")
                .setExtraCheese(true)
                .build();

        System.out.println(customPizza);
    }
}