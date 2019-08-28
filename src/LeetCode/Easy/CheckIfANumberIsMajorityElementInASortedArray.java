package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class CheckIfANumberIsMajorityElementInASortedArray {
    public static void main(String[] args) {
        int[] nums = {10,100,101,101};
        int target = 101;
        System.out.println(isMajorityElement(nums, target));
    }

    // I solved this one myself.
    public static boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int num : nums)
            if (num == target)
                ++count;
        return count > nums.length / 2;
    }
}
