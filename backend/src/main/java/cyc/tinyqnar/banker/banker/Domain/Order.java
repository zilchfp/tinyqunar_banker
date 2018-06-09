package cyc.tinyqnar.banker.banker.Domain;


import lombok.Data;
import org.bouncycastle.cms.Recipient;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="bank_order")
@Data
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Time deal_time;

    @Column
    private double money;


    @Column
    private int transferor_id;

    @Column
    private int recipient_id;




}
