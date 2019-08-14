package Sorting;

public class GenericMergeSort {
    public static void main(String[] args) {
        Double[] list  = {1.2,4.4,3.1,2.6,5.1};
        String[] names = {"bean", "jim", "bob", "period", "jesse"};
        mergeSort(list);
        mergeSort(names);

        for (var i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (var i : names) {
            System.out.print(i + " ");
        }
    }

    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) { // the list must be splittable.
            // new E[]; is not allowed. cast the Comparable array to E[]
            E[] left = (E[]) new Comparable[list.length/2];
            System.arraycopy(list, 0, left, 0, left.length);
            mergeSort(left);

            int rightLength = list.length - list.length / 2;
            E[] right = (E[])new Comparable[rightLength];
            System.arraycopy(list, left.length, right, 0, rightLength);
            mergeSort(right);

            merge(left, right, list);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] left, E[] right, E[] temp) {
        int leftIndex = 0, rightIndex = 0, tempIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) // while iteration is possible
        {
            if (left[leftIndex].compareTo(right[rightIndex]) <= 0) // left[current1] <= right[current2]
                temp[tempIndex++] = left[leftIndex++];
            else
                temp[tempIndex++] = right[rightIndex++];
        }

        // append the rest of the left list
        while (leftIndex != left.length)
            temp[tempIndex++] = left[leftIndex++];

        // append the rest of the left list
        while (rightIndex != right.length)
            temp[tempIndex++] = right[rightIndex++];
    }
}