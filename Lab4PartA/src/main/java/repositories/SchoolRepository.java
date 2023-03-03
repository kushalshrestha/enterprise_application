package repositories;

import domain.Book;
import domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
}
