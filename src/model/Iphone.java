package model;

public class Iphone extends Mobile implements Price {
    private String iosVersion;

    public Iphone(String name, String serialNumber, String color, String capacity, double price, int quantity, String iosVersion) {
        super(name, serialNumber, color, capacity, price, quantity);
        this.iosVersion = iosVersion;
    }

    @Override
    public double countBill() {
        return super.getPrice() * super.getQuantity();
    }

    @Override
    public String toString() {
        return super.toString() + "iosVersion='" + iosVersion + '\'' + '}';
    }
}
