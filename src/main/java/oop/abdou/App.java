package oop.abdou;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import oop.abdou.model.BankAccount;
import oop.abdou.model.CurrentAccount;
import oop.abdou.model.SavingAccount;

import java.security.Key;
import java.util.*;

public class App {
    public static void main(String[] args) throws JsonProcessingException {
        BankAccount c = new BankAccount() { //Question : objet annonyme - programation fonctionel - programtion sequentiel
            @Override
            public String getType() {
                return null;
            }
        };

        c.printBankLogo();

        BankAccount[] accounts = new BankAccount[4]; //cration des handels

        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i]);
        }

        accounts[0] = new CurrentAccount(40000,"MAD",2000);
        accounts[1] = new CurrentAccount(5000,"USD",3000);
        accounts[2] = new SavingAccount(60000,"MAD",2.5);
        accounts[3] = new SavingAccount(1000,"USD",4);

        for (BankAccount acc : accounts){
            System.out.println(acc.getType());

            if(acc instanceof CurrentAccount){
                System.out.println("Over Draft  = "+((CurrentAccount)acc).getOverDraft());
            }
            if (acc instanceof SavingAccount){
                System.out.println("Interest Rate = "+((SavingAccount)acc).getIntersetRate());
            }

        }

        System.out.println("=======List=======");

        List <BankAccount> bankAccountList = new ArrayList<BankAccount>();

        bankAccountList.add(new CurrentAccount(900,"USD",5000));
        bankAccountList.add(new CurrentAccount(10000,"MAD",5000));
        bankAccountList.add(new SavingAccount(12000,"MAD",1));
        bankAccountList.add(new SavingAccount(1000,"USD",2));
        bankAccountList.add(new SavingAccount(1000,"USD",3));

        for (BankAccount bl : bankAccountList){
            System.out.println(bl);
        }

        System.out.println("=======Map=======");

        Map <String,BankAccount> bankAccountMap = new HashMap<String,BankAccount>();

        bankAccountMap.put("c1",new CurrentAccount(900,"USD",8000));
        bankAccountMap.put("c2",new CurrentAccount(10900,"MAD",4000));
        bankAccountMap.put("c3",new SavingAccount(79900,"MAD",5));
        bankAccountMap.put("c4",new SavingAccount(2900,"USD",4));

        System.out.println(".......par key..........");

        for (String key : bankAccountMap.keySet()){
            System.out.println(bankAccountMap.get(key));
        }

        System.out.println(".......par valeur..........");

        for (BankAccount valeur : bankAccountMap.values()){
            System.out.println(valeur);
        }

        System.out.println(".......par valeur en JSON format..........");

        for (BankAccount valeur : bankAccountMap.values()){
            System.out.println(toJason(valeur));
        }

        //final int p = 3.14;


    }

    public static String toJason(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
    // format jason il a une relationa avec les getters
}


