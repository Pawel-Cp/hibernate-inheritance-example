package core.basesyntax.model.machine;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "machine")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private int year;
    private String maker;

    public Machine() {

    }

    public Machine(int year, String maker) {
        this.year = year;
        this.maker = maker;
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
