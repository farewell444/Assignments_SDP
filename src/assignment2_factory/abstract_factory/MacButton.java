package assignment2_factory.abstract_factory;

public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Rendering a button in Mac style.");
    }
}
