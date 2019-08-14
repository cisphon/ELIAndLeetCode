package Sorting;

public class GenericSelectionSort {
    public static void main(String[] args) {
        Double[] list  = {1.2,4.4,3.1,2.6,5.1};
        String[] names = {"bean", "jim", "bob", "period", "jesse"};
        selectionSort(list);
        selectionSort(names);

        for (var i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (var i : names) {
            System.out.print(i + " ");
        }
    }

    public static <E extends Comparable<E>> void selectionSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) { // finds the smallest element
                if(list[j].compareTo(list[min]) < 0) { // if list[j] < min: min = list[j]
                    min = j;
                }
            }
            if(min != i) { // if min != i: swap them
                E temp = list[min];
                list[min] = list[i];
                list[i] = temp;
            }
        }
    }
}
