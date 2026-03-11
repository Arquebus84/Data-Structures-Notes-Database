// ===============================================
// CSCI 3230A Data Structures
// Fall 2025
// Instructor: M Arif Rahman, Ph.D.
//
// Demonstration for actual time incurred in milliseconds
// for running a Selection Sort Algorithm
// with different input sizes.
//
// CHANGE THE INPUT SIZE AT LINE 31:
// replace (i+1) by (i+2) and (i+3)
// and see (wait longer for) the magic!
//
// Follow the comments for understanding/modifying
//
//===============================================

import java.util.Arrays;

public class MySelectionSort {
    public static void main(String args[]){
        int n = 5; // static number of test (int) arrays with various length

        int[][] arrs = new int[n][]; // storing the initial 'n' number arrays
        int[][] sortedArrs = new int[n][]; // storing the sorted 'n' number of arrays

        long[] times = new long[n]; // storing actual times in milliseconds for running the algorithm
        int[] sizes = new int[n]; // size of all arrays

        for (int i = 0; i < n; i++) {
            int size = (int) (Math.pow(10, (i + 1))); // size for each test array (CHANGE HERE! USE (i+2) or (i+3))
            int maxNum = 10 * (int) (Math.pow(10, (i + 1))); // a random number for ceiling

            sizes[i] = size;

            arrs[i] = new int[size]; // generate memory for storing the array
            for (int j = 0; j < size; j++) {
                arrs[i][j] = (int)(Math.random() * maxNum);
            } // assign random int numbers [0,maxNum] to each testing array

            //find the actual milliseconds time for running the selectionSort
            //algorithm on the test array to sort it
            long startTime = System.currentTimeMillis();
            sortedArrs[i] = selectionSort(arrs[i]);
            long endTime = System.currentTimeMillis();

            times[i] = endTime - startTime; // record the running time for each sorting example
        }


        // print the arrays with sizes and times separately
        // to see how input number changes the running time
        System.out.println("The Array Sizes Are:");
        System.out.println(Arrays.toString(sizes));
        System.out.println("Times in milliseconds for sorting each Array:");
        System.out.println(Arrays.toString(times));

    }


    public static int[] selectionSort(int[] arr) { // Do not worry about this part
        // We will cover Selection sort in details later
        // Just know that this sorts integers in ascending order

        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfCurrentMin = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[indexOfCurrentMin])
                    indexOfCurrentMin = j;
            int currentMin = arr[indexOfCurrentMin];
            arr[indexOfCurrentMin] = arr[i];
            arr[i] = currentMin;
        }
        return arr;
    }

}
