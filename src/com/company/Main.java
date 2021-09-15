package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;
        while(true){
            System.out.println("How many integers would you like to sort?");
            if(input.hasNextInt()){
                n = input.nextInt();
                input.nextLine();
                break;
            }
            System.out.println("Invalid input. Please enter the amount of integers you would like to sort.");
        }
        int[] a = getIntegers(n, input);
        sortIntegers(a);
        printIntegers(a);
    }

    public static int[] getIntegers(int n, Scanner input){
        System.out.println("Please enter " + n + " integers, separated by enter keystrokes.");
        int counter = 0;
        int[] a = new int[n];
        while(counter < n){
            if(input.hasNextInt()){
                a[counter] = input.nextInt();
                input.nextLine();
                counter++;
            }else{
                System.out.println("Invalid entry. Please try again.");
                input.nextLine();
            }
        }
        return a;
    }

    public static void printIntegers(int[] a){
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sortIntegers(int[] a){
        MergeSort.mergeSort(a);
    }
}