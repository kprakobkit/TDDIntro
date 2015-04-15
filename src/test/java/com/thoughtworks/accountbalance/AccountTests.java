package com.thoughtworks.accountbalance;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    private Account acct;

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        int startingBalance = 100;
        int depositAmount = 50;

        acct = new Account(startingBalance);

        acct.deposit(depositAmount);

        assertThat(acct.getBalance(), is(startingBalance + depositAmount));
    }

    @Test
    @Ignore
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){

    }

    @Test
    @Ignore
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){

    }
}
