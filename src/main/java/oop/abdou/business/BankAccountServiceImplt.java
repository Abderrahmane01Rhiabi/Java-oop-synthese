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
import java.util.stream.Collectors;

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

    @Override
    public List<BankAccount> getSavingAccounts() {


        //Declarative Approach
        List<BankAccount> result = bankAccountList.stream()
                                                   .filter(acc -> acc instanceof SavingAccount)
                                                   .collect(Collectors.toList());

        /*
        //Imperative Approach
            List<BankAccount> result = new ArrayList<>();

            for(BankAccount acc : bankAccountList){
                if(acc instanceof SavingAccount){
                    result.add(acc);
                }

                /*
                if(acc.getType().equals("SAVING_ACCOUNT")){
                    result.add(acc);
                }
                /
            }
        */
        return result;

    }

    @Override
    public List<BankAccount> getCurrentAccounts() {
        return bankAccountList.stream()
                              .filter(acc -> acc.getType().equals("CURRENT_ACCOUNT"))
                              .collect(Collectors.toList());
    }

    @Override
    public double getTotalBalance() {

        /*
        //Imperative Approach
        double sum = 0;

        for(BankAccount acc : bankAccountList){
            sum += acc.getBalance();
        }

        return sum;
        */

        //Declarative Approach

        return bankAccountList.stream()
                              .map(acc -> acc.getBalance())
                              .reduce(0.0,(a,v) -> a+v); //accumulator + valeur
                                     //valeur accumulateur
    }

    @Override
    public List<BankAccount> serchAccounts(Condition<BankAccount> condition) {

        List<BankAccount> res = new ArrayList<>();

        for(BankAccount acc : bankAccountList){
            if(condition.test(acc)){
                res.add(acc);
            }
        }

        return res;

    }
}
