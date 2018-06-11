package cyc.tinyqnar.banker.banker.Controller;


import cyc.tinyqnar.banker.banker.Domain.Order;
import cyc.tinyqnar.banker.banker.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/all")
    public List<Order> getAllUser() {
        return orderService.getAllOrder();
    }

    @Transactional
    @RequestMapping(value = "/order/delete", method = {RequestMethod.POST})
    public void OrderDelete(@RequestParam(value = "id")int id) {
        orderService.deleteById(id);
    }





//    @RequestMapping(value = "/ticket/add", method = {RequestMethod.POST, RequestMethod.GET})
//    public User TicketEdit(@RequestBody String ticket) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        User t = mapper.readValue(ticket, User.class);
//        return ticketService.updateTicket(t);
////    }


//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public int TicketDelete(@RequestParam(value = "id")int id) {
//        System.out.println(id);
//        return ticketService.deleteById(id);
//    }

//
//    @RequestMapping("/order")
//    public Order OrderFind() {
//        Order order = orderService.findByID(1);
//        if (order == null) {
//            System.out.println("null");
//        }
//        return order;
//    }


}
