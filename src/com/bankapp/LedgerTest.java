package com.bankapp;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LedgerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void CreateLedgerWithAllRequirementsAsDeposit() {
        Ledger l = new Ledger(100, "deposit");
        Assert.assertEquals(100, l.getAmount(), 100);
        Assert.assertEquals("deposit", l.getDescription());
    }

    @Test
    public void CreateLedgerWithAllRequirementsAsWithdraw() {
        Ledger l = new Ledger(100, "Withdraw");
        Assert.assertEquals(100, l.getAmount(), 100);
        Assert.assertEquals("Withdraw", l.getDescription());
    }

    @Test
    public void CreateLedgerWithoutAmount() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("amount cannot be 0");
        Ledger l = new Ledger(0, "");
    }

    @Test
    public void CreateLedgerWithoutDescription() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("description cannot be empty");
        Ledger l = new Ledger(100, "");
    }

    @Test
    public void CreateLedgerAmountis100() {
        Ledger l = new Ledger(100, "deposit");
        Assert.assertEquals(100, l.getAmount(), 100);
    }
}
