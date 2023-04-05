package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CD")
public class CD extends Product {
    private String artist;

    protected CD(){}

    public CD(String artist) {
        super();
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                ",productNumber=" + super.getName() +'\'' +
                ",price=" + super.getPrice() + '\'' +
                '}';
    }
}
