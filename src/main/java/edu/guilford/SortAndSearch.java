package edu.guilford;

public class SortAndSearch {
    // Add a static selectionSort method that takes an array of integers as a parameter
    // and sorts the array using the selection sort algorithm
    public static void selectionSort(int[] array) {
        // Loop through the array
        for (int i = 0; i < array.length; i++) {
            // Find the index of the smallest element in the array
            int smallest = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[smallest] > array[j])
                    smallest = j;
            }
            // Swap the smallest element with the first element in the array
            swap(array, i, smallest);
        }
    }

    // Add a static quickSort method that takes an array of integers as a parameter
    // and sorts the array using the quick sort algorithm
    public static void quickSort(int[] array) {
        // Call the recursive quickSort method
        quickSort(array, 0, array.length - 1);
    }

    // Add a static quickSort method that takes an array of integers and two integers
    // as parameters and sorts the array using the quick sort algorithm
    // This method is recursive
    public static void quickSort(int[] array, int low, int high) {
        // If the low index is less than the high index
        if (low < high) {
            // Partition the array
            int partitionIndex = partition(array, low, high);
            // Recursively call quickSort on the left and right partitions
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    // Add a static partition method that takes an array of integers and two integers
    // as parameters and returns an integer
    // This method is used by the quickSort method
    public static int partition(int[] array, int low, int high) {
        // Set the pivot to the last element in the array
        int pivot = array[high];
        // Set the partition index to the low index
        int partitionIndex = low;
        // Loop through the array
        for (int i = low; i < high; i++) {
            // If the current element is less than the pivot
            if (array[i] < pivot) {
                // Swap the current element with the element at the partition
                // index
                swap(array, i, partitionIndex);
                // Increment the partition index
                partitionIndex++;
            }
        }
        // Swap the element at the partition index with the pivot
        swap(array, partitionIndex, high);
        // Return the partition index
        return partitionIndex;
    }

    // Let's create a method that swaps two elements in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
