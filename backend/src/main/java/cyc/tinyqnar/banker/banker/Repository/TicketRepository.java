package cyc.tinyqnar.banker.banker.Repository;

import cyc.tinyqnar.banker.banker.Domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface TicketRepository extends JpaRepository<Ticket, Long> {


    List<Ticket> findAllByStartAndEnd(String start, String end);

    Ticket findById(int id);

    List<Ticket> findAllByAmountGreaterThan(int lowerBound);



    @Transactional
    int deleteById(int id);



}