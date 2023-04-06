package domain;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String author;
//	private String locationCode;
	private int publicationYear;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Address address;

	public Book() {
	}

	public Book(String title, String author, int publicationYear) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", publicationYear=" + publicationYear +
				", address=" + address +
				'}';
	}
}
