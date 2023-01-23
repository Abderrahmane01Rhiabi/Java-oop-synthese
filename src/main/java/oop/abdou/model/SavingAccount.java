package oop.abdou.model;

public class SavingAccount extends BankAccount{
    private double intersetRate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(double balance, String currency, double intersetRate) {
        super(balance, currency);
        this.intersetRate = intersetRate;
    }

    public double getIntersetRate() {
        return intersetRate;
    }

    public void setIntersetRate(double intersetRate) {
        this.intersetRate = intersetRate;
    }
}
