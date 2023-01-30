package oop.abdou.business;

import oop.abdou.model.BankAccount;

import java.util.function.Consumer;
import java.util.function.Function;

//Une interface fonctionnel : il contient une seul methode

//je l'ai ajouter juste pour filtre les donnees

//Sapplique just sur n'importe quils type
@FunctionalInterface
public interface Condition<T> { //Predicate deja existe
    boolean test(T ba);
}

/* //Sapplique just sur BankAccount
public interface Condition {
    boolean test(BankAccount ba);
}
*
 */

    //Consumer  |
    //Supplier  |-> functional interface
    //Function  |