package oop.abdou.business;

import oop.abdou.exceptions.AccountNotFoundException;
import oop.abdou.exceptions.BalancNotSufficientException;
import oop.abdou.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    //par defaut public abstarct class BankAccountService

    //par defaut : public abstract BankAccount addBankAccount(BankAccount account);

    BankAccount addBankAccount(BankAccount account);

    List<BankAccount> getAllAccounts();

    BankAccount getAccountById(String id) throws AccountNotFoundException;

    void addRandomData(int size);

    void credit(String accountId, double amount) throws AccountNotFoundException;

    void debit(String accountId, double amount) throws AccountNotFoundException, BalancNotSufficientException;

    void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalancNotSufficientException;

    List<BankAccount> getSavingAccounts();

    List<BankAccount> getCurrentAccounts();

    double getTotalBalance();

    //List<BankAccount> serchAccounts(Condition condition);
    List<BankAccount> serchAccounts(Condition<BankAccount> condition);

    /*transmettre une fonction à une méthode -> dans Java
     -> transmettre une fonction à une méthode le seul moyen c'est de
    transmettre un objet d'une interface (Condition) qui contient une seule méthode donc c'est ça
    la base de la programmation
    */
}

