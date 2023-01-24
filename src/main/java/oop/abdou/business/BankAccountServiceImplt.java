package oop.abdou.business;

import oop.abdou.exceptions.AccountNotFoundException;
import oop.abdou.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

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

    }

    @Override
    public void credit(String accountId, double amount) {

    }

    @Override
    public void debit(String accountId, double amount) {

    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) {

    }
}
