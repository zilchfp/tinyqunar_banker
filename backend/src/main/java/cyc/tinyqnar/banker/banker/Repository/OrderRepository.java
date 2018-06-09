package cyc.tinyqnar.banker.banker.Repository;

import cyc.tinyqnar.banker.banker.Domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepository extends JpaRepository<Order, Long> {



}
