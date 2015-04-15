package com.thoughtworks.accountbalance;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    private Account acct;
    private int startingBalance;
    private int depositAmount;
    private int withdrawAmount;

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        startingBalance = 100;
        depositAmount = 50;

        acct = new Account(startingBalance);

        acct.deposit(depositAmount);

        assertThat(acct.getBalance(), is(startingBalance + depositAmount));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        startingBalance = 100;
        withdrawAmount = 50;

        acct = new Account(startingBalance);

        acct.withdraw(withdrawAmount);

        assertThat(acct.getBalance(), is(startingBalance - withdrawAmount));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        startingBalance = 50;
        withdrawAmount = 100;

        acct = new Account(startingBalance);

        acct.withdraw(withdrawAmount);

        assertThat(acct.getBalance(), is(startingBalance));
    }
}
