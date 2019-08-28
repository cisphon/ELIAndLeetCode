package LeetCode.Easy;

import static LeetCode.Tools.printMatrix;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] nums = {{1,2}, {3,4}};
        nums = matrixReshape(nums, 1, 4);
        printMatrix(nums);
    }

    // I solved this one by myself.
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int matrixIndices = nums.length * nums[0].length;
        int newMatrixIndices = r * c;
        if (matrixIndices == newMatrixIndices) { // it's reshapable.
            int[][] reshaped = new int[r][c];
            r = 0; c = 0;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = 0; j < nums[i].length; ++j) {
                    if (c != reshaped[r].length) { // if c isn't the length of the row
                        reshaped[r][c] = nums[i][j];
                        ++c;
                    }
                    if (c == reshaped[r].length) { // if c overflows, go to the next row and restart the c to 0.
                        ++r; c = 0;
                    }
                }
            }
            return reshaped;
        }
        return nums; // return the original matrix given that it can't be reshaped.
    }
}
