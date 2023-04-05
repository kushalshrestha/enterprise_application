package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
public class Book extends Product{
    private String isbn;

    protected Book(){}

    public Book(String isbn) {
        super();
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ",productNumber=" + super.getName() +'\'' +
                ",price=" + super.getPrice() + '\'' +
                '}';
    }
}
