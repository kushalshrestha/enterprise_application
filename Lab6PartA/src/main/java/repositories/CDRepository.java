package repositories;

import domain.Address;
import domain.Book;
import domain.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CDRepository extends JpaRepository<CD, Long> {
    List<CD> findByArtistAndPriceLessThan(String artist, double price);

    List<CD> findByArtist(String artist);

    @Query("select c from CD c where c.artist = :artist and price > :price ")
    List<CD> getCDsByArtistAndPriceGreaterThan(@Param("artist") String artist, @Param("price") double price);


    @Query(value = "select * from CD  where artist='U2'",nativeQuery = true)
    List<CD> getU2Artist();

    @Query(value = "select c.artist, c.id from CD c  where artist='U2'",nativeQuery = true)
    List<Object[]> findU2Artist();
}
