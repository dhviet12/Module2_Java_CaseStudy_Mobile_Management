package Model;

public class Samsung extends Mobile implements Price {
    private String androidVersion;

    public Samsung(String name, String brand, String serialNumber, String color, String capacity, double price, int quantity, String androidVersion) {
        super(name, brand, serialNumber, color, capacity, price, quantity);
        this.androidVersion = androidVersion;
    }

    @Override
    public double countBill() {
        if (super.getColor().equalsIgnoreCase("black")) {
            return (super.getPrice() * super.getQuantity()) + (10000 * super.getQuantity());
        } else if (super.getColor().equalsIgnoreCase("white")) {
            return (super.getPrice() * super.getQuantity()) + (20000 * super.getQuantity());
        } else
            return super.getPrice() * super.getQuantity();
    }

    @Override
    public String toString() {
        return super.toString() + " Samsung{" +
                "androidVersion='" + androidVersion + '\'' +
                '}';
    }
}
