package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private int id;
    private String flightnumber;

    @Column(name="departure")
    private String from;
    @Column(name="destination")
    private String to;
    private Date data;

    protected Flight(){}

    public Flight(String flightnumber, String from, String to, Date data) {
        this.flightnumber = flightnumber;
        this.from = from;
        this.to = to;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightnumber='" + flightnumber + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", data=" + data +
                '}';
    }
}
