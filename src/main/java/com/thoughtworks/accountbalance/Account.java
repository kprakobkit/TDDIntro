package com.thoughtworks.accountbalance;

/**
 * Created by kprakobkit on 4/16/15.
 */
public class Account {
    private int balance;

    public Account(int startingBalance) {
        balance = startingBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}
