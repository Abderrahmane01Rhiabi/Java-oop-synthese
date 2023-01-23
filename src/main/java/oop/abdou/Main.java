package oop.abdou;

import oop.abdou.model.BankAccount;

import java.awt.image.BandCombineOp;

public class Main extends BankAccount {
    public static void main(String[] args) {

        String s1 = new String("Abdou");
        String s2 = new String("Abdou");

        System.out.println(s1 == s2); // il compare l'emplacement dans la memoire
        System.out.println(s1.equals(s2)); //il compare la valeur des objects

        System.out.println("=================");


        BankAccount c1 = new BankAccount();

        //c1.setId("1");
        //c1.setStatus();
        c1.setBalance(1000);
        c1.setCurrency("MAD");
        afficher(c1);

        BankAccount c2 = new BankAccount(4000,"MAD");
        afficher(c2);

        System.out.println("............................");
        BankAccount c3 = new BankAccount(4000, "MAD");

        c3.setId(c2.getId());
        System.out.println(c3);
        System.out.println(c2);

        System.out.println(c3.hashCode());
        System.out.println(c2.hashCode());


        System.out.println(c3.hashCode() == c2.hashCode());

        System.out.println("............................");

    }

    //une methode static n'accepte que les methode static
    public static void afficher(BankAccount account){
        System.out.println("*************************");
        System.out.println("Account Id : "+account.getId());
        System.out.println("Balance : "+account.getBalance());
        System.out.println("Status : "+account.getStatus());
        System.out.println("Currency : "+account.getCurrency());
        System.out.println(account.toString());
        System.out.println(account.hashCode());
        System.out.println(account.equals(account)); // il compare l'etat des objets
        System.out.println("-------------------------");
    }

}