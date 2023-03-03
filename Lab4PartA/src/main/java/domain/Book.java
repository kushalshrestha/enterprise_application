package domain;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String ISBN;
    private String title;
    private String author;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(name="book_publisher")
    private Publisher publisher;

    protected Book(){}

    public Book(String isbn, String title, String author){
        this.ISBN = isbn;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
