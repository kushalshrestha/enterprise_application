package repositories;

import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o.id from Order o where o.status= :status ")
    List<String> findOrderNumbersForClosedStatus(@Param("status") String status);

    @Query("select o.ordernr from Order o where o.customer.address.city= :city")
    List<String> findOrderNumbersByCity(@Param("city") String city);
}
