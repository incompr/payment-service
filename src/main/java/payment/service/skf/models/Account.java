package payment.service.skf.models;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private long id;

    @Column(name = "balance")
    private long balance;

    public Account() {
    }

    public Account(int id, long balance) {
        this.balance = balance;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "balance", nullable = false)
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    //  public void putMoney(long moneyAmount) {
    //     this.balance = balance + moneyAmount;
    // }


    @Override
    public String toString() {
        return "Account_id=" + id + ", balance=" + balance;
    }

}




