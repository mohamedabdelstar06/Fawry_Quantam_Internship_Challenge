package Product;

import java.time.LocalDate;

public class Cheese extends ExpirableProduct implements Shippable {

    private double weight;  // in kg

    public Cheese(String name, double price, int quantity, LocalDate expiryDate , double weight) {
        super(name,price,quantity,expiryDate);
        if(weight <= 0)
        {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
