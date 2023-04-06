package domain;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="CD.findByArtist",
		query = "select c from CD c where c.artist= :artist")
public class CD extends Product{
	private String artist;

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
//				", name='" + name + '\'' +
//				", description='" + description + '\'' +
//				", price=" + price +
				'}';
	}
}
