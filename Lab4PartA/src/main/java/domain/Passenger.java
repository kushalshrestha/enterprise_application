package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @OrderColumn(name="sequence")
    private List<Flight> flight = new ArrayList<Flight>();

    protected Passenger(){}

    public Passenger(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flight=" + flight +
                '}';
    }
}
