package com.bankapp;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void CreateCustomerWithName() {
        Customer customer = new Customer("Tony");
        Assert.assertEquals("Tony", customer.getName());
    }

    @Test
    public void CreateCustomerWithoutName() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Name cannot be empty");
        Customer customer = new Customer("");
    }

    @Test
    public void CreateCustomerBalanceShouldBe0() {
        Customer customer = new Customer("Tony");
        Assert.assertEquals(0.00, customer.getBalance(), 0.00);
    }

    @Test
    public void CreateCustomerWithBalance() {
        Customer customer = new Customer("Tony");
        customer.setBalance(200.00);
        Assert.assertEquals(200.00, customer.getBalance(), 200.00);
    }
    @Test
    public void CreateCustomerLedgersShouldBeLength0() {
        Customer customer = new Customer("Tony");
        Assert.assertEquals(0, customer.getLedger().size(), 0);
    }
    @Test
    public void CreateCustomerLedgersShouldBeLength1() {
        Customer customer = new Customer("Tony");
        Ledger newL = new Ledger(100, "deposit");
        customer.addLedger(newL);
        Assert.assertEquals(1, customer.getLedger().size(), 1);
    }

}
