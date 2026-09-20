package assignment2_factory.abstract_factory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println("Running on Windows platform");
        GUIFactory windowsFactory = new WindowsFactory();
        Application winApp = new Application(windowsFactory);
        winApp.renderUI();

        System.out.println("\nRunning on macOS platform");
        GUIFactory macFactory = new MacFactory();
        Application macApp = new Application(macFactory);
        macApp.renderUI();
    }
}