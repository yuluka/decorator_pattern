package model;

public class Espresso extends Beverage {

    public Espresso(String description, double cost) {
        super(description, cost);
    }

    @Override
    public double cost() {
        return getCost();
    }
}
