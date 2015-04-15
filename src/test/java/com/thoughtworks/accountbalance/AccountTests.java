package com.thoughtworks.accountbalance;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    int startingBalance = 100;
    Account acct;

    @Before
    public void setUpTestAccountWithStartingBalance() {
        acct = new Account(startingBalance);
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        int depositAmount = 50;

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
