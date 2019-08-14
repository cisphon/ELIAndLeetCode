package Sorting;

import static LeetCode.Tools.printArray;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5,1,4,2,3};
        mergeSort(array);

        printArray(array);
    }

    public static void mergeSort(int[] array) {
        if(array.length > 1) { // must be divisible by at least 2
            // Merge sort the first half
            int[] firstHalf = new int[array.length / 2];
            System.arraycopy(array, 0,
                    firstHalf, 0, array.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = array.length - array.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(array, array.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, array);
        }
    }

    public static void merge(int[] array1, int[] array2, int[] temp) {
        int current1 = 0, current2 = 0, current3 = 0;

        while (current1 < array1.length && current2 < array2.length) // while iteration is possible
        {
            if (array1[current1] < array2[current2])
                temp[current3++] = array1[current1++];
            else
                temp[current3++] = array2[current2++];
        }

        while (current1 < array1.length) // Put the rest of the array together
            temp[current3++] = array1[current1++];

        while (current2 < array2.length) // Put the rest of the array together
            temp[current3++] = array2[current2++];
    }
}
