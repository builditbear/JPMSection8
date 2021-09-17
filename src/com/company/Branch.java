package com.company;

import java.util.ArrayList;

public class Branch {
    private final String name;
    private final ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customer, double initialTransaction) {

    }

    // Returns true if customer was found and adding transaction to their record was
    // *attempted* - the attempt may still fail if an invalid amount is given, however.
    public boolean addCustomerTransaction(String customer, double transaction) {
        Customer c = findCustomer(customer);
        if(c == null){
            return false;
        }
        c.addTransaction(transaction);
        return true;
    }

    // Return value of null indicates customer with given name does not exist at this branch.
    public Customer findCustomer(String customer) {
        for (Customer c : customers) {
            if (c.getName().equals(customer)) {
                return c;
            }
        }
        return null;
    }
}
