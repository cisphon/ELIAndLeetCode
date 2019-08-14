package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[100000];

        for(int i = 0; i < a.length; i++) {
            int randomValue = (int) (Math.random() * i);
            a[i] = randomValue;
        }

        long start = System.currentTimeMillis();
        insertion_sort(a);
        long end = System.currentTimeMillis();

        System.out.println(end - start);

        start = System.currentTimeMillis();
        insertion_sort2(a);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void insertion_sort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j != 0; --j) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }
    }

    public static void insertion_sort2(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentValue = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentValue; --k) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentValue;
        }
    }
}