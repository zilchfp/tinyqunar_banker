package cyc.tinyqnar.banker.banker.Repository;

import cyc.tinyqnar.banker.banker.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findById(int id);

    List<User> findAllBy();

    int deleteById(int id);


//    List<User> findAllByStartAndEnd(String start, String end);
//
//    User findById(int id);
//
//    List<User> findAllByAmountGreaterThan(int lowerBound);
//
//
//
//    @Transactional
//    int deleteById(int id);





}