package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DVD")
public class DVD extends Product {
    private String genre;

    protected DVD(){}

    public DVD(String genre) {
        super();
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "genre='" + genre + '\'' +
                ",productNumber=" + super.getName() +'\'' +
                ",price=" + super.getPrice() + '\'' +
                '}';
    }
}
