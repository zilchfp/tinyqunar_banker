package cyc.tinyqnar.banker.banker.Service;

import cyc.tinyqnar.banker.banker.Domain.Order;
import cyc.tinyqnar.banker.banker.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

//    public Order findByID(int id) {
//        Order order = orderRepository.findByID(String.valueOf(id    ));
//        return order;
//
//    }
}
