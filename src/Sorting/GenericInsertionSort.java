package Sorting;

public class GenericInsertionSort {
    public static void main(String[] args) {
        Double[] list  = {1.2, 4.4, 3.1, 2.6, 5.1};
        String[] names = {"bean", "jim", "bob", "period", "jesse"};
        insertionSort(list);
        insertionSort(names);
        printArray(list);
        printArray(names);
    }

    public static <E> void printArray(E[] list) {
        for (E value: list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static <E extends Comparable<E>> void insertionSort(E[] list) {
        for (int i = 1; i < list.length; i++) {
            E currentValue = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k].compareTo(currentValue) > 0; --k) { // if k >= 0 and list[k] > currentValue:
                list[k + 1] = list[k]; // shift list[k] to list[k + 1]
            }
            list[k + 1] = currentValue; // Insert the currentValue into the sorted subarray.
        }
    }
}
