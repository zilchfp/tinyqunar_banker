package cyc.tinyqnar.banker.banker.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cyc.tinyqnar.banker.banker.Domain.User;
import cyc.tinyqnar.banker.banker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @Transactional
    @RequestMapping(value = "/user/delete", method = {RequestMethod.POST})
    public int UserDelete(@RequestParam(value = "id")int id) {
        System.out.println(id);
        return userService.deleteById(id);
    }

    @Transactional
    @RequestMapping(value = "/user/add", method = {RequestMethod.POST, RequestMethod.GET})
    public User UserEdit(@RequestBody String NewUser) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User u = mapper.readValue(NewUser, User.class);
        return userService.updateUser(u);
    }
}