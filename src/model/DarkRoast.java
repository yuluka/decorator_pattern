package model;

public class DarkRoast extends Beverage {

    public DarkRoast(String description, double cost) {
        super(description, cost);
    }

    @Override
    public double cost() {
        return getCost();
    }
}
