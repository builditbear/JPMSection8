package com.company;

import java.util.Scanner;
import java.util.Arrays;

public class MinimumElement {
    public static void main(String[] args){
        int[] a = readIntegers(10);
        System.out.println("The minimum number in given array is " + findMin(a) + ".");
    }

    public static int[] readIntegers(int count){
        Scanner input = new Scanner(System.in);
        int[] a = new int[count];
        int i = 0;
        while(i < count){
            System.out.println("Please enter integer #" + (i + 1) + ":");
            if(input.hasNextInt()){
                a[i] = input.nextInt();
                input.nextLine();
                i++;
            }else{
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return a;
    }

    public static int findMin(int[] a){
        // The minimum should be the first element of the array when sorted
        // in ascending order. By copying before sorting we avoid altering the original.
        int[] c = Arrays.copyOf(a, a.length);
        Arrays.sort(c);
        return c[0];
    }
}
