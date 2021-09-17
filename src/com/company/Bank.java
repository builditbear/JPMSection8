package com.company;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name){};

    public boolean addCustomer(String branch, String name, double initialTransaction){};

    public Branch findBranch(String branch){};

    public boolean listCustomers(){};
}
