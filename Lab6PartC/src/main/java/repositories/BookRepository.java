package repositories;

import domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b join fetch b.address")
    List<Book> findAllBooks();

    @Query("select b from Book b join fetch b.address where b.publicationYear < 1950")
    List<Book> findBookByPublicationYearLessThan1950();

    @Query("delete from Book b where b.publicationYear < 1950")
    void deleteBookByPublicationYearLessThan1950();
}
