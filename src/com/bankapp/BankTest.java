package com.bankapp;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BankTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void CreateNewBankCustomer() {
        Bank myBank = new Bank();
        Customer customer = myBank.addCustomer("John");
        Assert.assertEquals("John", customer.getName());
    }

    @Test
    public void CreateNewBankCustomerDeposit() throws Exception {
        Bank myBank = new Bank();
        myBank.addCustomer("John");
        double[] balances = myBank.deposit("John", 100.00);
        Assert.assertEquals(balances[0], 100.00, 0);
        Assert.assertEquals(balances[1], 100.00, 0);
    }

    @Test
    public void CreateNewBankInvalidCustomerDeposit() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage("Customer not found!");
        Bank myBank = new Bank();
        myBank.deposit("Lynn", 100.00);
    }

    @Test
    public void CreateNewBankCustomerWithdraw() throws Exception {
        Bank myBank = new Bank();
        myBank.addCustomer("John");
        myBank.deposit("John", 100.00);
        double[] balances = myBank.withdraw("John", 50.00);
        Assert.assertEquals(balances[0], 50.00, 0);
        Assert.assertEquals(balances[1], 50.00, 0);
    }

    @Test
    public void CreateNewBankInvalidCustomerWithdraw() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage("John's customer balance is: 100.0, You are trying to withdraw 150.0");
        Bank myBank = new Bank();
        myBank.addCustomer("John");
        myBank.deposit("John", 100.00);
        myBank.withdraw("John", 150.00);
    }

    @Test
    public void BankBalanceIs250() throws Exception {
        Bank myBank = new Bank();
        myBank.addCustomer("John");
        myBank.addCustomer("Lynn");
        myBank.deposit("John", 100.00);
        double[] balances = myBank.deposit("Lynn", 150.00);
        Assert.assertEquals(balances[0], 250.00, 0);
        Assert.assertEquals(balances[1], 150.00, 0);
    }
}
