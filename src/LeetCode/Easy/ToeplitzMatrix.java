package LeetCode.Easy;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };
        System.out.println(isToeplitzMatrix(matrix1));

        int[][] matrix2 = {
                {1,2},
                {5,2},
        };
        System.out.println(isToeplitzMatrix(matrix2));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length - 1; ++r) {
            for (int c = 0; c < matrix[r].length - 1; ++c) {
                int curr = matrix[r][c];
                int shiftBelow = matrix[r + 1][c + 1];
                if (curr != shiftBelow) {
                    return false;
                }
            }
        }

        return true;
    }
}
