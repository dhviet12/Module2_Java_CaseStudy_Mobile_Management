package model;

import java.io.Serializable;

public class Vertu extends Mobile implements Price, Serializable {
    private String material;

    public Vertu(String name, String serialNumber, String color, String capacity, double suggestedPrice, int quantity, String material) {
        super(name, serialNumber, color, capacity, suggestedPrice, quantity);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public double countBill() {
        switch (getMaterial()) {
            case "gold":
                return super.getSuggestedPrice() * super.getQuantity() + (200000 * super.getQuantity());
            case "sapphire":
                return super.getSuggestedPrice() * super.getQuantity() + (500000 * super.getQuantity());
            case "diamond":
                return super.getSuggestedPrice() * super.getQuantity() + (700000 * super.getQuantity());
        }
        return super.getSuggestedPrice() * super.getQuantity();
    }

    @Override
    public String toString() {
        return super.toString() + ", material='" + material + '\'' + '}';
    }
}
