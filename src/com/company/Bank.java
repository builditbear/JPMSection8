package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public boolean addBranch(String branch){
        if(findBranch(branch) != null) {
            return false;
        }
        branches.add(new Branch(branch));
        return true;
    }

    public boolean addCustomer(String branch, String customer, double initialTransaction){
        Branch b = findBranch(branch);
        if(b == null){
            return false;
        }
        return b.newCustomer(customer, initialTransaction);
    }

    public boolean addCustomerTransaction(String branch, String customer, double transaction){
        Branch b = findBranch(branch);
        if(b == null){
            return false;
        }
        return b.addCustomerTransaction(customer, transaction);
    }

    private Branch findBranch(String branch){
        for (Branch b : branches){
            if(b.getName().equals(branch)){
                return b;
            }
        }
        return null;
    }

    public boolean listCustomers(String branch, boolean printTransactions){
        Branch b = findBranch(branch);
        if(b == null){
            return false;
        }
        System.out.println("Customer details for branch " + b.getName());
        ArrayList<Customer> customers = b.getCustomers();
        if(customers != null){
            for(int i = 0; i < customers.size(); i++){
                Customer c = customers.get(i);
                System.out.println("Customer: " + c.getName() + "[" + (i + 1) + "]");
                // Prints out all valid transactions for this customer.
                ArrayList<Double> transactions = c.getTransactions();
                if(printTransactions && transactions != null){
                    System.out.println("Transactions");
                    for(int j = 0; j < transactions.size(); j++){
                        System.out.println("[" + (j + 1) + "]  Amount " + transactions.get(j));
                    }
                }
            }
        }
        return true;
    }
}
