import java.io.*;
import java.util.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
        System.out.println("Current balance after deposit: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
            System.out.println("Current balance after withdrawal: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw: " + amount + ", Insufficient funds!");
        }
    }
}

class BankOperation extends Thread {
    private BankAccount account;
    private boolean isDeposit;
    private double amount;

    public BankOperation(BankAccount account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    public void run() {
        synchronized (account) {
            if (isDeposit) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
        }
    }
}

public class bankot {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        
        BankOperation thread1 = new BankOperation(account, true, 200); // deposit
        BankOperation thread2 = new BankOperation(account, false, 300); // withdraw
        BankOperation thread3 = new BankOperation(account, true, 500); // deposit

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
