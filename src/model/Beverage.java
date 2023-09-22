package model;

public abstract class Beverage implements Cloneable {

    private String description;

    private double cost;

    public Beverage(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    public abstract double cost();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
