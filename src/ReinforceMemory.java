import java.util.HashMap;
import java.util.NoSuchElementException;

public class ReinforceMemory {
    public static void main(String[] args) {
        int[] a = new int[]{3,2,4};
        int[] sol = twoSum(a, 6);
        printArray(sol);
        Integer[] b = new Integer[] {1, 3, 2, 4};
        insertionSort(b);

        for (Integer i: b) {
            System.out.print(i.intValue() + " ");
        }
    }

    public static <E extends Comparable> void insertionSort(E[] list) {
        for (int i = 1; i < list.length; i++) {
            E value = list[i];
            int k;
            for (k = i - 1; k > 0 && list[k].compareTo(value) < 0; k--) {
                list[k + 1] = list[k];
            }
            list[k] = value;
        }
    }

    public static void printArray(int[] list) { // O(n) time
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] twoSum(int[] list, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            int complement = target - list[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(list[i], i);
        }

        throw new NoSuchElementException("ass");
    }
}
