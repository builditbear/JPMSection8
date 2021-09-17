package com.company;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private final ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        transactions = new ArrayList<Double>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction) {
        if(transaction > 0.01) {
            transactions.add(transaction);
        }else{
            System.out.println("Invalid transaction amount. Must be more than one cent.");
        }
    }
}
