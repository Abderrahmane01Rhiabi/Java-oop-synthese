package oop.abdou.business;

import oop.abdou.exceptions.AccountNotFoundException;
import oop.abdou.exceptions.BalancNotSufficientException;
import oop.abdou.model.AccountStatus;
import oop.abdou.model.BankAccount;
import oop.abdou.model.CurrentAccount;
import oop.abdou.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccountServiceImplt implements BankAccountService{

    List<BankAccount> bankAccountList = new ArrayList<>();

    @Override
    public BankAccount addBankAccount(BankAccount account) {
        bankAccountList.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccountList;
    }

    @Override
    public BankAccount getAccountById(String id) throws AccountNotFoundException {
        for(BankAccount bankAccount : bankAccountList){
            if(bankAccount.getId().equals(id)) {
                return bankAccount;
            }
        }
        throw new AccountNotFoundException("Bank Account Not Found");
    }

    @Override
    public void addRandomData(int size) {

        AccountStatus[] values = AccountStatus.values();

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            BankAccount bankAccount;
            if(Math.random() > 0.5){
                //les expresion ternair
                bankAccount = new CurrentAccount(Math.random()*10000,Math.random()>0.5?"MAD":"USD",Math.random()*5000);
                bankAccount.setStatus(values[random.nextInt(values.length)]);

            } else {
                bankAccount = new SavingAccount(Math.random()*10000,Math.random()>0.5?"MAD":"USD",2+Math.random()*6); //Entre 2 et 8
                bankAccount.setStatus(values[random.nextInt(values.length)]);
            }
            bankAccountList.add(bankAccount);
        }

    }

    //Doit etre transactionnelle
    @Override
    public void credit(String accountId, double amount) throws AccountNotFoundException {
        BankAccount accountById = getAccountById(accountId);

        accountById.setBalance(accountById.getBalance()+amount);

    }

    //Doit etre transactionnelle
    @Override
    public void debit(String accountId, double amount) throws AccountNotFoundException, BalancNotSufficientException {

        BankAccount accountById = getAccountById(accountId);

        if(accountById.getBalance() < amount) throw new BalancNotSufficientException("Balance Not Sufficient");

        accountById.setBalance(accountById.getBalance()-amount);

    }

    //Doit etre transactionnelle
    @Override
    public void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalancNotSufficientException {

        credit(accountDestination,amount);
        debit(accountSource,amount);
    }
}
