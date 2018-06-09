package cyc.tinyqnar.banker.banker.Repository;

import cyc.tinyqnar.banker.banker.Domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepository extends JpaRepository<Order, Long> {


    //TODO: 多表查询处理
    @Query(value = "select  tbl_order.* from inner join tbl_ticket on tbl_order.id = tbl_ticket.id where tbl_ticket.id = ?1;", nativeQuery = true)
    Order findByID(String id);


}
