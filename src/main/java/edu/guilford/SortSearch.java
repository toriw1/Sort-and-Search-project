package edu.guilford;

import java.text.DecimalFormat;
//import java.util.Arrays;
import java.util.Random;

public class SortSearch {
    public static void main(String[] args) {
        // Define two constants MAX (number of elements in array)
        // and RANGE (range of values in array)
        final int MAX = 10000;
        final int RANGE = 50000;
        Random rand = new Random();
        DecimalFormat formatter = new DecimalFormat("0.00");
        DecimalFormat smallFormatter = new DecimalFormat("0.0000");

        // Create an array of MAX integers with random assigned values in RANGE
        int[] array = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            array[i] = rand.nextInt(1, RANGE + 1);
        }
        // System.out.println("Original: " + Arrays.toString(array));
        // Time how long it takes to sort the array
        long startTime = System.nanoTime();
        // Sort the array using the selection sort algorithm
        SortAndSearch.selectionSort(array);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Selection sort took " + formatter.format(duration / 1.e6) + " milliseconds");
        // System.out.println("Sorted: " + Arrays.toString(array));

        // Shuffle the array for the next test
        shuffle(array);
        // sort the array using the quick sort algorithm
        startTime = System.nanoTime();
        SortAndSearch.quickSort(array);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Quick sort took " + formatter.format(duration / 1.e6) + " milliseconds");

        shuffle(array);
        // use linear search to find a random value in the array
        int target = rand.nextInt(1, RANGE + 1);
        startTime = System.nanoTime();
        int index = SortAndSearch.linearSearch(array, target);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Linear search took " + smallFormatter.format(duration / 1.e6) + " milliseconds");
        System.out.println("Linear search found " + target + " at index " + index);
    
        // to use a binary search, the array must be sorted
        // sort the array using quick sort
        SortAndSearch.quickSort(array);
        // We only have to do the sort once, and then we can do as many searches as we want
        // use binary search to find a random value in the array
        startTime = System.nanoTime();
        index = SortAndSearch.binarySearch(array, target);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Binary search took " + smallFormatter.format(duration / 1.e6) + " milliseconds");
        System.out.println("Binary search found " + target + " at index " + index);
    }

    // Add a static method to shuffle the array
    public static void shuffle(int[] array) {
        // Loop through the array
        for (int i = 0; i < array.length; i++) {
            // Generate a random index
            int randomIndex = (int) (Math.random() * array.length);
            // Swap the current element with the element at the random index calling the
            // swap method
            swap(array, i, randomIndex);
        }
    }

    // Add a static method to swap two elements in an array
    public static void swap(int[] array, int i, int j) {
        // Store the value of the element at index i in a temporary variable
        int temp = array[i];
        // Set the value of the element at index i to the value of the element at
        // index j
        array[i] = array[j];
        // Set the value of the element at index j to the value of the element at
        // index i
        array[j] = temp;
    }
}
