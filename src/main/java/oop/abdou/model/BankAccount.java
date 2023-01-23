package oop.abdou.model;

import java.util.Objects;
import java.util.UUID;

public abstract class BankAccount {
    private String Id;
    private double balance;
    private AccountStatus status;
    private String currency;

    public BankAccount(){
        this.status = AccountStatus.CREATED;
        this.Id = UUID.randomUUID().toString();
    }

    public BankAccount(double balance, String currency){
        this(); //appel au constructeur BankAccount();
        this.balance = balance;
        this.currency = currency;
    }

    public String getId() {
        return Id;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "Id='" + Id + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.Id)+
                Objects.hashCode(this.status)+
                Objects.hashCode(this.balance)+
                Objects.hashCode(this.currency);
    }
}
