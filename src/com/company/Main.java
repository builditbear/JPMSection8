package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Test code for Bank > Branch > Customer classes, in order of dependency.
        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
        bank.listCustomers("Adelaide", false);
        // Test code for MobilePhone class.
        /*MobilePhone myPhone = new MobilePhone();
        myPhone.use();
        myPhone.use();*/
    }
}                  