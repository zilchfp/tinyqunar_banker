package cyc.tinyqnar.banker.banker.Controller;

import cyc.tinyqnar.banker.banker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;




//    //消费服务例子
//    @Autowired
//    RestTemplate restTemplate;
//
//    @RequestMapping("/Login")
//    public String LoginCheck() {
//        return restTemplate.
//                getForObject("http://SELLER/ticket/query", String.class);
//    }

//    @RequestMapping("/Query")
////    @ResponseBody
//    public User TicketQuery() {
//
//        User res = ticketService.findByTicketID(1);
//        if (res == null) {
//            System.out.println("null");
//        } else {
//            System.out.println("not null");
//        }
//        return res;
//    }

}