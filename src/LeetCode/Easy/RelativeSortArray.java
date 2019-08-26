package LeetCode.Easy;


import java.util.*;

import static LeetCode.Tools.printArray;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        printArray(relativeSortArray(arr1, arr2));
    }

    public static int[] countingSort(int[] arr1, int[] arr2) {
        int k = 0;
        int[] cnt = new int[1001], ans = new int[arr1.length];
        for (int i : arr1)                      // Count each number in arr1.
            ++cnt[i];
        for (int i : arr2)                      // Sort the common numbers in both arrays by the order of arr2.
            while (cnt[i]-- > 0)
                ans[k++] = i;
        for (int i = 0; i < 1001; ++i)          // Sort the numbers only in arr1.
            while (cnt[i]-- > 0)
                ans[k++] = i;
        return ans;
    }

    // this is a 3ms solution. it's faster than 42.59%
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length];

        List<Integer> list = new ArrayList<>();
        for (int num : arr1) // O(N), N = arr1.length;
            list.add(num);

        Collections.sort(list); // O(N * log(N)), N = list.size();

        int k = 0;
        for (int i = 0; i < arr2.length; ++i) {
            int val = arr2[i];
            int index = Collections.binarySearch(list, val); // O(log N)
            while (index >= 0) // while binarySearch finds results
            {
                arr3[k++] = list.get(index); // add that value to ans
                list.remove(index); // remove it from the list
                index = Collections.binarySearch(list, val); // O(log N)
            }
        }

        for (int i = 0; i < list.size(); ++i) // add the remaining elements to the array
            arr3[k++] = list.get(i);

        return arr3;
    }
}