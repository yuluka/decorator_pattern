package model;

public class HouseBlend extends Beverage {

    public HouseBlend(String description, double cost) {
        super(description, cost);
    }

    @Override
    public double cost() {
        return getCost();
    }
}
