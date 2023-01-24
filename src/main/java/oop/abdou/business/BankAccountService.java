package oop.abdou.business;

import oop.abdou.exceptions.AccountNotFoundException;
import oop.abdou.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    //par defaut public abstarct class BankAccountService

    //par defaut : public abstract BankAccount addBankAccount(BankAccount account);

    BankAccount addBankAccount(BankAccount account);
    List<BankAccount> getAllAccounts();
    BankAccount getAccountById(String id) throws AccountNotFoundException;
    void addRandomData(int size);
    void credit(String accountId, double amount);
    void debit(String accountId, double amount);
    void transfer(String accountSource, String accountDestination, double amount);



}
