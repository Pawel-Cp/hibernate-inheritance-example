package core.basesyntax.model.machine;

import jakarta.persistence.Entity;

@Entity
public class Truck extends Machine {
    private String color;
    private double maxAllowedWeight;

    public Truck() {

    }

    public Truck(String color, double maxAllowedWeight, int year, String maker) {
        super(year, maker);
        this.color = color;
        this.maxAllowedWeight = maxAllowedWeight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMaxAllowedWeight() {
        return maxAllowedWeight;
    }

    public void setMaxAllowedWeight(double maxAllowedWeight) {
        this.maxAllowedWeight = maxAllowedWeight;
    }
}
