package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private long id;

    private String locationCode;

    @OneToMany(mappedBy = "address")
    private List<Book> books;

    protected Address(){}

    public Address(String locationCode) {
        this.locationCode = locationCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", location='" + locationCode + '\'' +
                ", books=" + books +
                '}';
    }
}
