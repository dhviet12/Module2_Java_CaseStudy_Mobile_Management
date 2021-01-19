package model;

import java.io.Serializable;

public class Samsung extends Mobile implements Price, Serializable {
    private String androidVersion;

    public Samsung(String name, String serialNumber, String color, String capacity, double suggestedPrice, int quantity, String androidVersion) {
        super(name, serialNumber, color, capacity, suggestedPrice, quantity);
        this.androidVersion = androidVersion;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    @Override
    public double countBill() {
        if (super.getColor().equalsIgnoreCase("black")) {
            return (super.getSuggestedPrice() * super.getQuantity()) + (10000 * super.getQuantity());
        } else if (super.getColor().equalsIgnoreCase("white")) {
            return (super.getSuggestedPrice() * super.getQuantity()) + (20000 * super.getQuantity());
        } else if (super.getColor().equalsIgnoreCase("gold")) {
            return (super.getSuggestedPrice() * super.getQuantity()) + (30000 * super.getQuantity());
        } else
            return super.getSuggestedPrice() * super.getQuantity();
    }


    @Override
    public String toString() {
        return super.toString() + ", androidVersion='" + androidVersion + '\'' + '}';
    }
}
