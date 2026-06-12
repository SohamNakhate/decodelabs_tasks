package Task_03;
import java.util.InputMismatchException;
import java.util.Scanner;

import Task_03.*;

// Main Class
public class DecodeLabs_Java_P3 {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000.00);

        ATM atm = new ATM(account);

        System.out.println("================================");
        System.out.println("      WELCOME TO ATM");
        System.out.println("================================");
        System.out.println("Initial Balance: 10000.00");

        atm.start();
    }
}