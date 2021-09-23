package com.company;

import java.util.ArrayList;
import java.util.Scanner;
//For usage in Album & Song classes.
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Test code for Album > Song class, in order of dependency.
        ArrayList<Album> albums = new ArrayList<>();

        Album a = new Album("My Incredible Songs", "Mr.Incredible");
        a.addSong("The Incredible Bulk", 10.32);
        a.addSong("No Butts, No Glory", 1.01);
        a.addSong("Nice Glutes", 3.13);
        a.addSong("Saturday Night Beaver", 12.54);
        a.addSong("In the Gravy", 50.12);
        albums.add(a);

        Album b = new Album("Now THAT'S What I Call Snoozing!", "Mr. Sandman");
        b.addSong("Dreamland Anthem", 5.43);
        b.addSong("Chloroform", 10.43);
        b.addSong("Food Coma", 4.55);
        b.addSong("Oops! I Slept Through It Again", 4.56);
        b.addSong("Sho Schleepy", 7.87);
        albums.add(b);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(1).addToPlayList("Dreamland Anthem", playlist);
        albums.get(1).addToPlayList("Food Coma", playlist);
        albums.get(0).addToPlayList("Nice Glutes", playlist);
        albums.get(0).addToPlayList("Saturday Night Beaver", playlist);

        // Testing overloaded version of addToPlayList.
        albums.get(0).addToPlayList(5, playlist);
        albums.get(1).addToPlayList(2, playlist);
        albums.get(1).addToPlayList(5, playlist);

        // This index should not exist, but should also not result in an error.
        albums.get(0).addToPlayList(5, playlist);
        // These should not be added, as they are duplicates.
        albums.get(0).addToPlayList("Nice Glutes", playlist);
        albums.get(0).addToPlayList("Saturday Night Beaver", playlist);
        albums.get(1).addToPlayList(2, playlist);
        albums.get(1).addToPlayList(4, playlist);



        System.out.println();
        System.out.println();

        PlaylistUI.UI(playlist);



//        // Test code for Bank > Branch > Customer classes, in order of dependency.
//        Bank bank = new Bank("National Australia Bank");
//
//        bank.addBranch("Adelaide");
//
//        bank.addCustomer("Adelaide", "Tim", 50.05);
//        bank.addCustomer("Adelaide", "Mike", 175.34);
//        bank.addCustomer("Adelaide", "Percy", 220.12);
//
//        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
//        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
//        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);
//
//        bank.listCustomers("Adelaide", true);
//        bank.listCustomers("Adelaide", false);


        // Test code for MobilePhone class.
        /*MobilePhone myPhone = new MobilePhone();
        myPhone.use();
        myPhone.use();*/
    }


}