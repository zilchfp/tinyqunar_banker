package cyc.tinyqnar.banker.banker.Service;

import cyc.tinyqnar.banker.banker.Domain.User;
import cyc.tinyqnar.banker.banker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean increaseBalance(int id, double money) {
        User user = userRepository.findById(id);
        double oriBalance = user.getBalance();
        user.setBalance(oriBalance + money);
        userRepository.save(user);
        System.out.println("ori:"+oriBalance);
        System.out.println("after increase:" + userRepository.findById(id).getBalance());
        return (userRepository.findById(id).getBalance() == (oriBalance+money));
    }

    public boolean decreaseBalance(int id, double money) {
        User user = userRepository.findById(id);
        double oriBalance = user.getBalance();
        user.setBalance(oriBalance - money);
        userRepository.save(user);
        return (userRepository.findById(id).getBalance() == (oriBalance+money));
    }

    public List<User> getAllUser() {
        return userRepository.findAllBy();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public int deleteById(int id) {
        return userRepository.deleteById(id);
    }

    public User findByID(int id) {
        return userRepository.findById(id);
    }

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



}
