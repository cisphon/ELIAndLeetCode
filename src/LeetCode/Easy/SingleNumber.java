package LeetCode.Easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(anotherSolution(nums));
        // 4, 1, 2, 1, 2
        // 0 ^ 4 ^ 2 ^ 1 ^ 2 ^ 1
        // 0 ^ (2 ^ 2) ^ (1 ^ 1) ^ 4 (rearranged) XOR is commutative
        // 0 ^ 0 ^ 0 ^ 4
        // 0 ^ 4
        // 4
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
        {
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        Iterator<Integer> iter = set.iterator();
        return iter.next();
    }

    public static int anotherSolution(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            result = result ^ nums[i]; // XOR basically removes the dupes
        }
        return result;
    }
}
