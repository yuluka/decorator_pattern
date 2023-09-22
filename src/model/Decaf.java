package model;

public class Decaf extends Beverage {

    public Decaf(String description, double cost) {
        super(description, cost);
    }

    @Override
    public double cost() {
        return getCost();
    }
}
