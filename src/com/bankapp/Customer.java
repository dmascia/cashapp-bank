package com.bankapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer
 */
public class Customer {
    private String name;
    private List<Ledger> ledger;
    private double balance;

    /**
     * Constructor
     * @param name - customer name
     */
    public Customer(String name) throws IllegalArgumentException {
        if ( name.length() == 0 || name.isEmpty() )  {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.balance = 0.00;
            this.name = name;
            this.ledger = new ArrayList<Ledger>();
        }
    }

    /**
     * Get Customer balance
     *
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Set Customer balance
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Get Customer name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * List of Customer Ledgers
     *
     * @return Ledgers[]
     */
    public List<Ledger> getLedger() {
        return ledger;
    }

    /**
     * Add new Ledger Entry to Customer
     * Big O -> O(1)
     * @param ledger
     */
    public void addLedger(Ledger ledger) {
        this.ledger.add(ledger);
    }
}
