package Sorting;

public class GenericBubbleSort {

    public static void main(String[] args) {
        Double[] list  = {1.2,4.4,3.1,2.6,5.1};
        String[] names = {"bean", "jim", "bob", "period", "jesse"};
        bubbleSort(list);
        bubbleSort(names);

        for (var i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (var i : names) {
            System.out.print(i + " ");
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean sorted = false;

        while(!sorted)
        {
            sorted = true;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i].compareTo(list[i+1]) > 0) { // if list[i] > list[i+1]: swap them
                    E temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
