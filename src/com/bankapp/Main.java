package com.bankapp;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            Bank myBank = new Bank();

            myBank.addCustomer("Dave");
            myBank.addCustomer("John");
            myBank.addCustomer("Paul");
            myBank.addCustomer("Jennifer");
            myBank.addCustomer("Alice");

            System.out.println(Arrays.toString(myBank.deposit("Dave", 100.00)));
            System.out.println(Arrays.toString(myBank.deposit("John", 180.00)));
            System.out.println(Arrays.toString(myBank.withdraw("Dave", 5.00)));
            System.out.println(Arrays.toString(myBank.withdraw("John", 205.00)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
