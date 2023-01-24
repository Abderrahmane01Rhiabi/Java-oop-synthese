package oop.abdou.model;

public class SavingAccount extends BankAccount{
    private double interestRate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(double balance, String currency, double intersetRate) {
        super(balance, currency);
        this.interestRate = intersetRate;
    }

    public double getIntersetRate() {
        return interestRate;
    }

    public void setIntersetRate(double intersetRate) {
        this.interestRate = intersetRate;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "intersetRate=" + interestRate +" "+super.toString()+
                '}';
    }

    @Override
    public String getType() {
        return "SAVING_ACCOUNT";
    }
}
