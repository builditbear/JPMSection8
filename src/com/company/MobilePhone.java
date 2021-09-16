package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

// Solution to Lesson 108: ArrayList Challenge Part 1.
public class MobilePhone {
    private ArrayList<Contact> contactList;
    private Scanner input;

    public MobilePhone() {
        this.contactList = new ArrayList<>();
        this.input = new Scanner(System.in);
    }

    public void use(){
        boolean quit = false;
        while(!quit){
            System.out.println("Enter 0 to quit.");
            System.out.println("Enter 1 to print all contacts available on this mobile phone.");
            System.out.println("Enter 2 to add a new contact.");
            System.out.println("Enter 3 to update a contact with a new number.");
            System.out.println("Enter 4 to remove a contact.");
            System.out.println("Enter 5 to search for a contact.");

            if(input.hasNextInt()){
                int choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 0:
                        System.out.println("Exiting mobile phone.");
                        quit = true;
                        break;
                    case 1:
                        printContacts();
                        break;
                    case 2:
                        addContact();
                        break;
                    case 3:
                        updateContact();
                        break;
                    case 4:
                        removeContact();
                        break;
                    case 5:
                        searchContact();
                        break;
                    default:
                        System.out.println("Invalid entry. Choice must be between 0 and 5.");
                }
            }else{
                System.out.println("Invalid entry.");
                input.nextLine();
            }
        }
    }

    private void printContacts(){
        if(contactList.isEmpty()){
            System.out.println("No contacts have been added yet!");
        }else{
            for(Contact c : contactList){
                System.out.println(c.toString());
            }
        }
    }

    private void addContact(){
        System.out.println("What is this new contact's name?");
        String name = input.nextLine();
        String phoneNumber = inputPhoneNumber(name);
        contactList.add(new Contact(name, phoneNumber));
    }

    private void updateContact(){
        System.out.println("Whose contact are we changing?");
        String name = input.nextLine();
        int index = contactIndexLookup(name);
        if(index < 0){
            contactMissingMessage();
        }else{
            Contact c = contactList.get(index);
            c.setPhoneNumber(inputPhoneNumber(name));
            System.out.println("Phone number updated.");
        }
    }

    private void removeContact(){
        System.out.println("Whose contact would you like to remove?");
        int index = contactIndexLookup(input.nextLine());
        if(index < 0){
            contactMissingMessage();
        }else{
            contactList.remove(index);
        }

    }

    private void searchContact(){
        System.out.println("Whose contact info are you looking for?");
        int index = contactIndexLookup(input.nextLine());
        if(index < 0){
            contactMissingMessage();
        }else{
            System.out.println(contactList.get(index));
        }
    }
    
    // Will return the index of the desired contact's location in the contactList if it exits. -1 is returned otherwise.
    private int contactIndexLookup(String name){
        int index = -1;
        for(int i = 0; i < contactList.size(); i++){
            Contact c = contactList.get(i);
            if(c.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    private String inputPhoneNumber(String name){
        System.out.println("What is " + name + (name.endsWith("s") ? "'" : "'s") +
                " phone number? Enter the number without hyphens or spaces.");
        String phoneNumber;
        while(true){
            if(input.hasNextLong()){
                phoneNumber = input.nextLine();
                if(phoneNumber.length() == 10){
                    break;
                }else{
                    System.out.println("Phone number must be exactly 10 digits long.");
                }
            }else{
                System.out.println("Invalid input.");
            }
        }
        return phoneNumber;
    }

    private void contactMissingMessage(){
        System.out.println("No contact with that name exists on this mobile phone.");
    }
}
