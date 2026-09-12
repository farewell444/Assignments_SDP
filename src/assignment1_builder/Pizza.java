package assignment1_builder;

public class Pizza {
    private final String dough;
    private final String sauce;
    private final String topping;
    private final boolean extraCheese;

    public Pizza(String dough, String sauce, String topping, boolean extraCheese) {
        this.dough = dough;
        this.sauce = sauce;
        this.topping = topping;
        this.extraCheese = extraCheese;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public String getTopping() {
        return topping;
    }

    public String getSauce() {
        return sauce;
    }

    public String getDough() {
        return dough;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping='" + topping + '\'' +
                ", extraCheese=" + extraCheese +
                '}';
    }
}
