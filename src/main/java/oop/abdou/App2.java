package oop.abdou;

import oop.abdou.business.BankAccountService;
import oop.abdou.business.BankAccountServiceImplt;
import oop.abdou.exceptions.AccountNotFoundException;
import oop.abdou.exceptions.BalancNotSufficientException;
import oop.abdou.model.BankAccount;
import oop.abdou.model.CurrentAccount;
import oop.abdou.model.SavingAccount;
import oop.abdou.utils.DataTransformationUtils;

public class App2 {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImplt();

        bankAccountService.addRandomData(5);

        //bankAccountService.getAllAccounts().forEach(account -> System.out.println(DataTransformationUtils.toJason(account)));
        //bankAccountService.getAllAccounts().forEach(account -> System.out.println(account));

        BankAccount acc = new CurrentAccount(10000,"MAD",500);
        acc.setId("CC1");

        BankAccount acc2 = new SavingAccount(10000,"MAD",1.5);

        bankAccountService.addBankAccount(acc);
        bankAccountService.addBankAccount(acc2);


        try {

            System.out.println(DataTransformationUtils.toJason(bankAccountService.getAccountById(acc.getId())));
            bankAccountService.debit(acc.getId(),1000000);
            System.out.println(DataTransformationUtils.toJason(acc));

            System.out.println("================TRANSFER=================");
            bankAccountService.transfer(acc.getId(),acc2.getId(),2000);

            System.out.println(DataTransformationUtils.toJason(acc));
            System.out.println(DataTransformationUtils.toJason(acc2));


        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (BalancNotSufficientException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("***********SUITE DE PROGRAMME***********");

        //catch (AccountNotFoundException e | BanlancNotSufficentException e){...}
        //On peux le mette dans une catch seul Exception

    }
}
