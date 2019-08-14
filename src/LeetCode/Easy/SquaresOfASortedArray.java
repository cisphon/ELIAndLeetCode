package LeetCode.Easy;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] array = {-4,-1,0,3,10};

        array = sortedSquares(array);

        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static int[] sortedSquares(int[] A) {
        int[] sorted = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            sorted[i] = A[i] * A[i];
        }

        Arrays.sort(sorted);

        return sorted;
    }
}
