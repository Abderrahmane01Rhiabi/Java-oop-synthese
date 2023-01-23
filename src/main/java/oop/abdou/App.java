package oop.abdou;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import oop.abdou.model.BankAccount;

import java.security.Key;
import java.util.*;

public class App {
    public static void main(String[] args) throws JsonProcessingException {
        BankAccount[] accounts = new BankAccount[4]; //cration des handels

        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i]);
        }

        accounts[0] = new BankAccount(40000,"MAD");
        accounts[1] = new BankAccount(5000,"USD");
        accounts[2] = new BankAccount(60000,"MAD");
        accounts[3] = new BankAccount(1000,"USD");

        for (BankAccount acc : accounts){
            System.out.println(acc);
        }

        System.out.println("=======List=======");

        List <BankAccount> bankAccountList = new ArrayList<BankAccount>();

        bankAccountList.add(new BankAccount(900,"USD"));
        bankAccountList.add(new BankAccount(10000,"MAD"));
        bankAccountList.add(new BankAccount(12000,"MAD"));
        bankAccountList.add(new BankAccount(1000,"USD"));
        bankAccountList.add(new BankAccount(1000,"USD"));

        for (BankAccount bl : bankAccountList){
            System.out.println(bl);
        }

        System.out.println("=======Map=======");

        Map <String,BankAccount> bankAccountMap = new HashMap<String,BankAccount>();

        bankAccountMap.put("c1",new BankAccount(900,"USD"));
        bankAccountMap.put("c2",new BankAccount(10900,"MAD"));
        bankAccountMap.put("c3",new BankAccount(79900,"MAD"));
        bankAccountMap.put("c4",new BankAccount(2900,"USD"));

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

    }

    public static String toJason(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
}
