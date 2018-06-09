package cyc.tinyqnar.banker.banker.Controller;

import cyc.tinyqnar.banker.banker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController {

    @Autowired
    private UserService userService;
//
//    @RequestMapping("/Login")
//    public boolean LoginCheck() {
//
//        return true;
//    }
//
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