package LeetCode.Easy;

import static LeetCode.Tools.printArray;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,0,1,2,3};
        anotherSolution(nums);
        printArray(nums);
    }

    public static void moveZeroes(int[] nums) {
        int end = nums.length; // the end will change because we won't want to revisit 0s.
        for (int i = 0; i < end;) {
            int value = nums[i];
            if (value == 0) {
                --end;

                int k;
                for (k = i + 1; k < nums.length; k++) {
                    nums[k - 1] = nums[k]; // shift everything down
                }
                nums[k-1] = value; // place the 0 on the end.
            } else {
                ++i;
            }
        }
    }

    public static void anotherSolution(int[] nums) {
        int insertPos = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, insertPos);
                insertPos++;
            }
        }
    }

    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    public static void andAnotherSolution(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
