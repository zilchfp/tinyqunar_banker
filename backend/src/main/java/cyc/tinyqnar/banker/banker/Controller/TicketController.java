package cyc.tinyqnar.banker.banker.Controller;

import cyc.tinyqnar.banker.banker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.*;

@EnableEurekaServer
@RestController
public class TicketController {

    @Autowired
    private UserService userService;

//    @RequestMapping("/ticket/query")
//    public List<User> RestTicketQuery() {
//        List<User> restUserList = ticketService.findRestTickets();
//        if (restUserList == null) {
//            System.out.println("null");
//        }
//        return restUserList;
//    }
//
//    @RequestMapping(value = "/ticket/delete", method = RequestMethod.POST)
//    public int TicketDelete(@RequestParam(value = "id")int id) {
//        System.out.println(id);
//        return ticketService.deleteById(id);
//    }
//
//
//    @RequestMapping(value = "/ticket/add", method = {RequestMethod.POST, RequestMethod.GET})
//    public User TicketEdit(@RequestBody String ticket) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        User t = mapper.readValue(ticket, User.class);
//        return ticketService.updateTicket(t);
//    }
}