package model;

import java.io.Serializable;

public class Mobile implements Serializable {

    private String name;
    private String serialNumber;
    private String color;
    private String capacity;
    private double suggestedPrice;
    private int quantity;

    public Mobile() {
    }

    public Mobile(String name, String serialNumber, String color, String capacity, double suggestedPrice, int quantity) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.capacity = capacity;
        this.suggestedPrice = suggestedPrice;
        this.quantity = quantity;
    }

    public double getSuggestedPrice() {
        return suggestedPrice;
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


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  "Mobile{" +
                "name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", suggestedPrice=" + suggestedPrice + '\'' +
                ", quantity=" + quantity + '\'';
    }
}
