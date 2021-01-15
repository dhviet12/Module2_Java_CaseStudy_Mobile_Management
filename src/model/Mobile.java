package model;

public class Mobile {

    private String name;
    private String serialNumber;
    private String color;
    private String capacity;
    private double price;
    private int quantity;

    public Mobile(String name, String serialNumber, String color, String capacity, double price, int quantity) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.capacity = capacity;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getCapacity() {
        return capacity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
