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

    // Add a linear or sequential search algorithm
    public static int linearSearch(int[] array, int target) {
        // Loop through the array
        // We're going to go through each element one at a time and stop when we find what we're looking for
        for (int i = 0; i < array.length; i++) {
            // If the current element is equal to the target
            if (array[i] == target) {
                // Return the index of the current element
                return i;
            }
        }
        // Return -1 if the target is not found (we get to the end of the array and we can't find it)
        return -1;
    }

    // Add a binary search algorithm
    public static int binarySearch(int[] array, int target) {
        // Set the low index to 0
        int low = 0;
        // Set the high index to the last element in the array
        int high = array.length - 1;
        // Loop through the array
        while (low <= high) {
            // Set the middle index to the middle of the array
            int middle = (low + high) / 2;
            // If the middle element is equal to the target
            if (array[middle] == target) {
                // Return the middle index
                return middle;
            }
            // If the middle element is less than the target
            if (array[middle] < target) {
                // Set the low index to the middle index plus one
                low = middle + 1;
            }
            // If the middle element is greater than the target
            if (array[middle] > target) {
                // Set the high index to the middle index minus one
                high = middle - 1;
            }
        }
        // Return -1 if the target is not found (we get to the end of the array and we can't find it)
        return -1;
    }
    

}
