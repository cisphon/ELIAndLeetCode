package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

import static LeetCode.Tools.printArray;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum TS = new TwoSum();
        int[] a = new int[]{3,2,4};
        int[] sol = TS.twoSum3(a, 6);
        printArray(sol);
    }

    public int[] twoSum1(int[] nums, int target) { // O(n^2) time
        int[] solution = new int[]{-1, -1};

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) { // O(n) time
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) // O(n)
            map.put(nums[i], i); // Value, Index

        for (int i = 0; i < nums.length; i++) { // O(n)
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum3(int[] nums, int target) { // one pass O(n) time
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // Iterate over list
            int complement = target - nums[i]; // compute complement
            if (map.containsKey(complement)) { // if we have the complement
                return new int[] { map.get(complement), i }; // return the complement
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}