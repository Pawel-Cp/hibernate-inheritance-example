package core.basesyntax.model.machine;

import jakarta.persistence.Entity;

@Entity
public class Car extends Machine {
    private int horsePower;
    private String model;

    public Car() {

    }

    public Car(int horsePower, String model, int year, String maker) {
        super(year, maker);
        this.horsePower = horsePower;
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
