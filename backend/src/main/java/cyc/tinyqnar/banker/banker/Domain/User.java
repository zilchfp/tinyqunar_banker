package cyc.tinyqnar.banker.banker.Domain;



import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="bank_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String qunar_id;

    @Column
    private double balance;

}
