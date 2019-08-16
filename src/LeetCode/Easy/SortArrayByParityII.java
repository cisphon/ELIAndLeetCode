package LeetCode.Easy;

import java.util.*;

import static LeetCode.Tools.printArray;

public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] parity = {3,1,4,2};
        parity = sortArrayByParityII(parity);
        printArray(parity);
    }

    // I tried doing a two pointer solution like this one but got confused.
    public static int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1, n = A.length;
        while (i < n && j < n) {
            while (i < n && A[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && A[j] % 2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }
        return A;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
