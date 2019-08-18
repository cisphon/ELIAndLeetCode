package LeetCode.Easy;

import static LeetCode.Tools.printMatrix;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        printMatrix(matrix1);

        matrix1 = transpose(matrix1);
        printMatrix(matrix1);

        int[][] matrix2 = {
                {1,2,3},
                {4,5,6}
        };
        printMatrix(matrix2);

        matrix2 = transpose(matrix2);
        printMatrix(matrix2);
    }

    public static int[][] transpose(int[][] A) { // I produced this O(n^2) solution by myself!
        int[][] T = new int[A[0].length][A.length];
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[r].length; ++c) {
                if (T[c][r] == 0) { // if the Transposed matrix is 0 -- it doesn't exist.
                    T[c][r] = A[r][c];
                }
            }
        }
        return T;
    }
}