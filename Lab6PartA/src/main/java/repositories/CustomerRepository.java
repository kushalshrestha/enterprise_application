package repositories;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAll();

    List<Customer> findByCountryName(String name);

    @Query("select c.firstname, c.lastname from Customer c where c.address.city= :city ")
    List<Object[]> findFirstLastNameByCity(@Param("city") String city);

}

