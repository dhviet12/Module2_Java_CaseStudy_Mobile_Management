package Model;

public class Mobile {
    //properties
    private String name;
    private String brand;
    private String serialNumber;
    private String color;
    private String capacity;
    private double price;
    private int quantity;

    public Mobile(String name, String brand, String serialNumber, String color, String capacity, double price, int quantity) {
        this.name = name;
        this.brand = brand;
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
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
