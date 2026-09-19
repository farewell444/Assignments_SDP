package assignment2_factory.factory_method;

public abstract class Logistics {
    public void planDelivery() {
        Transport transport = createTransport();
        System.out.println("Logistic notification");
        transport.deliver();
    }

    public abstract Transport createTransport();
}
