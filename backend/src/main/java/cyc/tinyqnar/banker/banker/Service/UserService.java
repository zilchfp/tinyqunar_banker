package cyc.tinyqnar.banker.banker.Service;

import cyc.tinyqnar.banker.banker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    //根据出发地点与目的地查票
//    public List<User> findAllByStartAndEnd(String start, String end) {
//        return userRepository.findAllByStartAndEnd(start, end);
//    }
//
//    public User findByTicketID(int id) {
//        return userRepository.findById(id);
//    }
//
//    public List<User> findRestTickets() {
//        return userRepository.findAllByAmountGreaterThan(0);
//    }
//
//
//    public int deleteById(int id) {
//        return userRepository.deleteById(id);
//    }
//
//
//    public User updateTicket(User user) {
//        return userRepository.save(user);
//    }


}
