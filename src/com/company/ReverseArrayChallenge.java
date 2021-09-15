package com.company;

import java.util.Arrays;

public class ReverseArrayChallenge {
    public static void main(String[] args){
        int[] a = MinimumElement.readIntegers(10);
        System.out.println(Arrays.toString(a));
        reverse(a);
        System.out.println(Arrays.toString(a));
    }

    private static void reverse(int[] a){
        int l = 0;
        int r = a.length - 1;
        while(l < r){
            int temp = a[r];
            a[r] = a[l];
            a[l] = temp;
            l++;
            r--;
        }
    }
}
