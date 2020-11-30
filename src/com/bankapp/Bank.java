package com.bankapp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Bank
 */
public class Bank {
    private Map<String, Customer> customerMap;
    private double balance;

    /**
     * Constructor
     */
    public Bank() {
        this.customerMap = new HashMap<>();
        this.balance = 0;
    }

    /**
     * Get Bank Balance
     * @return balance
     */
    private double getBalance() {
        return balance;
    }

    /**
     * Set Bank Balance
     *
     * @param balance
     */
    private void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Add a new customer to the bank
     * Big O -> O(1)
     *
     * @param name - customer name
     * @return Customer
     */
    public Customer addCustomer(String name) {
        Customer customer = new Customer(name);
        customerMap.put(name, customer);

        return customer;
    }

    /**
     * Deposit money into the bank
     * Big O -> O(1)
     *
     * @param name - customer's name
     * @param amount - deposit amount
     * @return double[] - Bank Balance, Customer Balance
     * @throws Exception
     */
    public double[] deposit(String name, Double amount) throws Exception{
        double[] balances = new double[2];

        if ( customerMap.containsKey(name) ) {
            Customer customer = customerMap.get(name);
            Ledger newEntry = new Ledger(amount, "deposit");
            customer.addLedger(newEntry);
            customer.setBalance(customer.getBalance() + amount);
            this.setBalance(this.getBalance() + amount);

            balances[0] = this.getBalance();
            balances[1] = customer.getBalance();
        } else {
            throw new Exception("Customer not found!");
        }

        return balances;
    }

    /**
     * Withdraw money from the bank
     * Big O -> O(1)
     *
     * @param name - customer name
     * @param amount - withdraw amount
     * @return double[] - Bank Balance, Customer Balance
     * @throws Exception
     */
    public double[] withdraw(String name, Double amount) throws Exception{
        double[] balances = new double[2];

        if (customerMap.containsKey(name)) {
            Customer customer = customerMap.get(name);
            if ( customer.getBalance() < amount ) {
                throw new Exception(name + "'s customer balance is: " + customer.getBalance() + ", You are trying to withdraw " + amount);
            } else {
                Ledger newEntry = new Ledger(amount, "withdrawal");
                customer.addLedger(newEntry);

                customer.setBalance(customer.getBalance() - amount);
                this.setBalance(this.getBalance() - amount);

                balances[0] = this.getBalance();
                balances[1] = customer.getBalance();
            }
        } else {
            throw new Exception("Customer not found!");
        }

        return balances;
    }
}
