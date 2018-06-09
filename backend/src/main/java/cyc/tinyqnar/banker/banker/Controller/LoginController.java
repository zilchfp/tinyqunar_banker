package cyc.tinyqnar.banker.banker.Controller;

import cyc.tinyqnar.banker.banker.Domain.Ticket;
import cyc.tinyqnar.banker.banker.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/Login")
    public boolean LoginCheck() {

        return true;
    }

    @RequestMapping("/Query")
//    @ResponseBody
    public Ticket TicketQuery() {

        Ticket res = ticketService.findByTicketID(1);
        if (res == null) {
            System.out.println("null");
        } else {
            System.out.println("not null");
        }
        return res;
    }

}