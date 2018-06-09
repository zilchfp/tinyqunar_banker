package cyc.tinyqnar.banker.banker.Controller;

import cyc.tinyqnar.banker.banker.Domain.User;
import cyc.tinyqnar.banker.banker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableEurekaServer
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/user/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

//    @RequestMapping("/ticket/query")
//    public List<User> RestTicketQuery() {
//        List<User> restUserList = ticketService.findRestTickets();
//        if (restUserList == null) {
//            System.out.println("null");
//        }
//        return restUserList;
//    }
//

//
//
//    @RequestMapping(value = "/ticket/add", method = {RequestMethod.POST, RequestMethod.GET})
//    public User TicketEdit(@RequestBody String ticket) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        User t = mapper.readValue(ticket, User.class);
//        return ticketService.updateTicket(t);
//    }
}