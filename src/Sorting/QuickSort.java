package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] list = {1, 6, 2, 5, 3, 4};
        quickSort(list);

        for (int v : list) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] list) { // initializer
        quickSort(list, 0, list.length - 1); // call helper
    }

    private static void quickSort(int[] list, int first, int last) { // helper
        if (last > first) { // the first index must be on the left and last index on the right
            int pivotIndex = partition(list, first, last); // sorts the list a little and places the pivot between them.
            quickSort(list, first, pivotIndex - 1); // recursively call the left side of the pivot
            quickSort(list, pivotIndex + 1, last); // recursively call the right side of the pivot
        }
    }

    private static int partition(int[] list, int first, int last) { // partition the array
        int pivot = list[first]; // initially the pivot is just picked to be the beginning element
        int low = first + 1; // the low is just after the pivot
        int high = last; // the high is at the end

        while (high > low) { // while the indices are not the same
            while (low <= high && list[low] <= pivot) // search forward from left
                low++;

            while (low <= high && list[high] > pivot) // search backward from right
                high--;

            if (high > low) {
                swap(list, high, low); // swap high and low
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        if (pivot > list[high]) { // swap pivot with list[high]
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
