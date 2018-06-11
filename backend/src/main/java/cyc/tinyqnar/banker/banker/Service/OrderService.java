package cyc.tinyqnar.banker.banker.Service;

import cyc.tinyqnar.banker.banker.Domain.Order;
import cyc.tinyqnar.banker.banker.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;


    public List<Order> getAllOrder() {
        return orderRepository.findAllBy();
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }



    public void deleteById(int id) {orderRepository.deleteById(id);}

//    public Order findByID(int id) {
//        Order order = orderRepository.findByID(String.valueOf(id    ));
//        return order;
//
//    }
}
