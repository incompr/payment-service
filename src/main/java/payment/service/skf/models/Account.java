package payment.service.skf.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import payment.service.skf.exception.NegativeAmountException;
import payment.service.skf.exception.NotEnoughMoneyException;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;

    @Min(value = 0, message = "Balance should be greater than 0") //disable credit
    @Column(name = "balance")
    private long balance;

    public Account() {
    }

    public Account(int id, long balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "balance", nullable = false)
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void takeMoney(long amount) {
        if (this.balance >= amount) {
            this.balance = balance - amount;
        } else {
            throw new NotEnoughMoneyException();
        }
    }

    public void putMoney(long amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new NegativeAmountException();
        }

    }

    @Override
    public String toString() {
        return "Account_id=" + id + ", balance=" + balance;
    }

}




