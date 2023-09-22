package model;

public abstract class CondimentDecorator extends Beverage {

    private Beverage beverage;

    public CondimentDecorator(String description, double cost) {
        super(description, cost);
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        if (getBeverage() == null) {
            return getCost();
        }

        return getCost() + getBeverage().getCost();
    }
}
