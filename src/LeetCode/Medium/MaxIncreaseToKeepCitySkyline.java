package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static LeetCode.Tools.printArray;
import static LeetCode.Tools.printMatrix;

public class MaxIncreaseToKeepCitySkyline {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    // I solved this one by myself.
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] skylineTopBottom = topBottomSkyline(grid);
        int[] skylineLeftRight = leftRightSkyline(grid);

        int[][] newGrid = minComparison(skylineTopBottom, skylineLeftRight);

        int sum = 0;
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[r].length; ++c) {
                sum += (newGrid[r][c] - grid[r][c]);
            }
        }
        return sum;
    }

    public static int[][] minComparison(int[] topBottom, int[] leftRight) {
        int[][] grid = new int[topBottom.length][leftRight.length];

        int TBIndex = 0, LRIndex = 0; // topBottom index, leftRightIndex
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[r].length; ++c) {
                grid[r][c] = Math.min(topBottom[TBIndex], leftRight[LRIndex]);
                if (++TBIndex == topBottom.length) {
                    TBIndex = 0;
                    ++LRIndex;
                }
            }
        }
        return grid;
    }

    // finds the largest number in each column
    public static int[] topBottomSkyline(int[][] grid) {
        int[] res = new int[grid[0].length];
        int index = 0;
        for (int c = 0; c < grid[0].length; ++c) {
            int max = -1;
            for (int r = 0; r < grid.length; ++r) {
                if (grid[r][c] > max)
                    max = grid[r][c];
            }
            res[index++] = max;
        }
        return res;
    }

    // find the largest number in each row
    public static int[] leftRightSkyline(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int r = 0; r < grid.length; ++r) {
            int max = -1;
            for (int c = 0; c < grid[r].length; ++c) {
                if (grid[r][c] > max)
                    max = grid[r][c];
            }
            res[r] = max;
        }
        return res;
    }
}
