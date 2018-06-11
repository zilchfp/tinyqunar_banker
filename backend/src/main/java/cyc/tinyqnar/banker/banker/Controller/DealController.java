package cyc.tinyqnar.banker.banker.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cyc.tinyqnar.banker.banker.Domain.Order;
import cyc.tinyqnar.banker.banker.Domain.User;
import cyc.tinyqnar.banker.banker.Service.OrderService;
import cyc.tinyqnar.banker.banker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DealController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/deal/add", method = {RequestMethod.POST, RequestMethod.GET})
    public int UserEdit(@RequestBody String NewOrder) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Order o = mapper.readValue(NewOrder, Order.class);
        User transfor = userService.findByID(o.getTransferor_id());
        User recipient = userService.findByID(o.getRecipient_id());
        //判断转出方余额是否够
        if (transfor.getBalance() < o.getMoney()) {
            return 0;
        } else {
            boolean trans = userService.decreaseBalance(transfor.getId(), o.getMoney());
            boolean recei = userService.increaseBalance(recipient.getId(), o.getMoney());
            if (trans && recei) {
                System.out.println("update balance!");
                orderService.updateOrder(o);
            } else {
                return -1;
            }
        }
        return 1;
    }

    @RequestMapping(value = "/deal/addnew", method = {RequestMethod.POST, RequestMethod.GET})
    public int UserEdit(  @RequestParam(value = "money") double money,
                          @RequestParam(value = "transferor_id")int transferor_id,
                          @RequestParam(value = "recipient_id")int recipient_id) {
        Order o = new Order(transferor_id, recipient_id ,money);

        long time =  new Date().getTime();
        o.setDeal_date(new SimpleDateFormat("yyyy-MM-dd").format(time));
        o.setDeal_time(new SimpleDateFormat("HH:mm:ss").format(time));

        User transfor = userService.findByID(transferor_id);
        User recipient = userService.findByID(recipient_id);
        //判断转出方余额是否够
        if (transfor.getBalance() < money) {
            return 0;
        } else {
            boolean trans = userService.decreaseBalance(transferor_id, money);
            boolean recei = userService.increaseBalance(recipient_id, money);
            if (trans && recei) {
                System.out.println("update balance!");
                orderService.updateOrder(o);
            } else {
                return -1;
            }
        }
        return 1;
    }
}
