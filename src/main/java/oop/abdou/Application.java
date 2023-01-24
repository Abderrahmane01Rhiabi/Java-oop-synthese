package oop.abdou;

import oop.abdou.business.BankAccountService;
import oop.abdou.business.BankAccountServiceImplt;
import oop.abdou.exceptions.AccountNotFoundException;
import oop.abdou.model.BankAccount;
import oop.abdou.model.CurrentAccount;
import oop.abdou.model.SavingAccount;

import java.util.List;
import java.util.function.Consumer;

public class Application {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImplt();

        bankAccountService.addBankAccount(new CurrentAccount(2000,"MAD",1000));
        bankAccountService.addBankAccount(new SavingAccount(1000,"USD",1.2));

        BankAccount accTest = new CurrentAccount(3000,"MAD",2000);
        accTest.setId("CC1");

        bankAccountService.addBankAccount(accTest);

        List<BankAccount>  bankAccountList = bankAccountService.getAllAccounts();


        System.out.println("************V2 FOR****************");
        for(BankAccount ba : bankAccountList){
            System.out.println(ba);
        }

        System.out.println("************V3 FOR****************");
        bankAccountList.forEach(new Consumer<BankAccount>() {
            @Override
            public void accept(BankAccount account) {
                System.out.println(account);
            }
        });

        System.out.println("************V4 FOR****************");
        bankAccountList.forEach(account -> System.out.println(account));

        System.out.println("************V4 FOR****************");
        bankAccountList.forEach(System.out::println);

        System.out.println("----------------------------------");

        /*
        try {

            BankAccount accountByiD2 = bankAccountService.getAccountById("CC2");
            System.out.println(accountByiD2);

        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        */

        try {
            BankAccount accountByiD2 = bankAccountService.getAccountById("CC2");
            System.out.println(accountByiD2);
        } catch (AccountNotFoundException ac) {
            System.out.println(ac.getMessage());
            ac.printStackTrace();
        }

        System.out.println("***********SUITE DE PROGRAMME***********");

    }
}
