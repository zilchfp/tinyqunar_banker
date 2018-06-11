package cyc.tinyqnar.banker.banker.Domain;


import lombok.Data;
import org.bouncycastle.cms.Recipient;

import javax.persistence.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="bank_order")
@Data
public class Order {

    public Order() {

    }

    public Order(int transferor_id, int recipient_id, double money) {
        this.transferor_id = transferor_id;
        this.recipient_id = recipient_id;
        this.money = money;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String deal_date;

    @Column
    private String deal_time;

    @Column
    private double money;


    @Column
    private int transferor_id;

    @Column
    private int recipient_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeal_date() {
        return deal_date;
    }

    public void setDeal_date(String deal_date) {
        this.deal_date = deal_date;
    }

    public String getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(String deal_time) {
        this.deal_time = deal_time;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getTransferor_id() {
        return transferor_id;
    }

    public void setTransferor_id(int transferor_id) {
        this.transferor_id = transferor_id;
    }

    public int getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(int recipient_id) {
        this.recipient_id = recipient_id;
    }
}
