package Sorting;

public class HeapSort {
    public static void main(String[] args) {
        int[] list = {53, -44, 2, 4, 1, -5, -3, 3, 3, 1, -4, 0, 5};
        heapSort(list);

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    public static void heapSort(int[] list) {
        Heap<Integer> heap = new Heap<>(); // max heap

        for (int i = 0; i < list.length; i++) // Add elements to the heap
            heap.add(list[i]);

        for (int i = list.length - 1; i >= 0; i--) // remove elements from max heap
            list[i] = heap.remove(); // removing elements returns sorted order
    }
}
