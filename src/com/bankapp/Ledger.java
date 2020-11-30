package com.bankapp;

import java.util.ArrayList;
import java.util.Date;

/**
 * Ledger
 */
public class Ledger {
    private double amount;
    private String description;
    private Date insertedAt;

    /**
     * Constructor
     * @param amount
     * @param description
     */
    public Ledger(double amount, String description)
        throws IllegalArgumentException{
        if ( amount == 0 ) {
            throw new IllegalArgumentException("amount cannot be 0");
        } else if ( description.length() == 0 || description.isEmpty() ) {
            throw new IllegalArgumentException("description cannot be empty");
        } else  {
            this.amount = amount;
            this.description = description;
            this.insertedAt = new Date();
        }
    }

    /**
     * Get Ledger amount
     *
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Get Ledger description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }
}
