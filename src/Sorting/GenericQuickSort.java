package Sorting;

public class GenericQuickSort {
    public static void main(String[] args) {
        String[] names = {"bean", "jim", "bob", "period", "jesse"};
        quickSort(names);
        printList(names);
    }

    public static <E extends Comparable> void quickSort(E[] list) { // initializer
        quickSort(list, 0, list.length - 1);
    }

    public static <E extends Comparable> void quickSort(E[] list, int first, int last) { // helper
        if (last > first) { // the first index must be on the left and last index on the right
            int pivotIndex = partition(list, first, last); // sorts the list a little and places the pivot between them.
            quickSort(list, first, pivotIndex - 1); // recursively call the left side of the pivot
            quickSort(list, pivotIndex + 1, last); // recursively call the right side of the pivot
        }
    }

    public static <E extends Comparable> int partition(E[] list, int first, int last) {
        E pivot = list[first]; // initially the pivot is just picked to be the beginning element
        int low = first + 1; // the low is just after the pivot
        int high = last; // the high is at the end

        while (high > low) { // while the indices are not the same
            while (low <= high && list[low].compareTo(pivot) <= 0) // search forward from left
                low++;

            while (low <= high && list[high].compareTo(pivot) > 0) // search backward from right
                high--;

            if (high > low) {
                swap(list, high, low); // swap high and low
            }
        }

        while (high > first && list[high].compareTo(pivot) >= 0)
            high--;

        if (pivot.compareTo(list[high]) > 0) { // swap pivot with list[high]
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    public static <E extends Comparable> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static <E> void printList(E[] list) {
        for (E value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}