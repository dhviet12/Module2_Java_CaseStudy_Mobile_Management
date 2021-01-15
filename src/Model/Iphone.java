package Model;

public class Iphone extends Mobile implements Price {
    private String iosVersion;

    public Iphone(String name, String brand, String serialNumber, String color, String capacity, double price, int quantity, String iosVersion) {
        super(name, brand, serialNumber, color, capacity, price, quantity);
        this.iosVersion = iosVersion;
    }

    @Override
    public double countBill() {
        return super.getPrice()*super.getQuantity();
    }

    @Override
    public String toString() {
        return super.toString() + "Iphone{" +
                "iosVersion='" + iosVersion + '\'' +
                '}';
    }
}
