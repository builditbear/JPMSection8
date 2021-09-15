package com.company;

public class MergeSort {
    public static void mergeSort(int[] a) {
        mergeSort(a, new int[a.length], 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] temp, int l, int r){
        if(l < r){
            // Find the midpoint of the array.
            int m = (l + r) / 2;
            // Sort the left and right halves.
            mergeSort(a, temp, l, m);
            mergeSort(a, temp, m + 1, r);
            // Merge the left and right sorted halves, sorting by simple comparison of values from left to right.
            merge(a, temp, l, m, r);
        }
    }

    private static void merge(int[] a, int[] temp, int l, int m, int r){
        // Copy the elements of the target array into our temp array.
        System.arraycopy(a, l, temp, l, r + 1 - l);
        // Tracks which values of the sorted halves we're comparing.
        int lIndex = l;
        int rIndex= m + 1;
        // Tracks position in target array we're currently assigning to.
        int current = l;
        // Assign the lesser of the two numbers being compared from each half to the next place in the target array.
        while(lIndex <= m && rIndex <= r){
            if(temp[lIndex] <= temp[rIndex]){
                a[current] = temp[lIndex];
                lIndex++;
            }else{
                a[current] = temp[rIndex];
                rIndex++;
            }
            current++;
        }
        // Assign any remaining left half elements to the target array. Not necessary for the right half as any
        // remaining elements will be in the right place.
        while(lIndex <= m){
            a[current] = temp[lIndex];
            lIndex++;
            current++;
        }
    }
}
