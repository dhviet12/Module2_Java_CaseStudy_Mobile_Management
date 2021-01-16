package model;

public class Iphone extends Mobile implements Price {
    private String iosVersion;

    public Iphone(String name, String serialNumber, String color, String capacity, double suggestedPrice, int quantity, String iosVersion) {
        super(name, serialNumber, color, capacity, suggestedPrice, quantity);
        this.iosVersion = iosVersion;
    }

    @Override
    public double countBill() {
        if(super.getCapacity().equalsIgnoreCase("256gb")){
            return (super.getSuggestedPrice() * super.getQuantity()) + (50000 * super.getQuantity());
        } else if(super.getCapacity().equalsIgnoreCase("512gb")){
            return (super.getSuggestedPrice() * super.getQuantity()) + (100000 * super.getQuantity());
        } else
        return super.getSuggestedPrice() * super.getQuantity();
    }

    @Override
    public String toString() {
        return super.toString() + "iosVersion='" + iosVersion + '\'' + '}';
    }
}
