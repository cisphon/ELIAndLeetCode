package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        System.out.println((nums));
    }

    // http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
    // this is the "A Linear Time Majority Vote Algorithm"
    public static int mooreVotingAlgorithm(int[] nums) {
        int count = 0, ret = 0;
        for (int num: nums) {
            if (count == 0)
                ret = num;
            if (num != ret)
                count--;
            else
                count++;
        }
        return ret;
    }

    // O(n * log(n)) 1ms
    public static int sorting(int[] nums) {
        Arrays.sort(nums); // O(n * log(n))
        return nums[nums.length / 2];
    }

    // Bit manipulation 3ms
    public static int bitManipulation(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums)
            for (int i=0; i<32; i++)
                if ((num>>(31-i) & 1) == 1)
                    bit[i]++;
        int ret=0;
        for (int i=0; i<32; i++) {
            bit[i]=bit[i]>nums.length/2?1:0;
            ret += bit[i]*(1<<(31-i));
        }
        return ret;
    }

    // O(n) time.
    // O(n) space.
    public static int majorityElement(int[] nums) {
        int n = nums.length, ret = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1); // increment it
            else
                map.put(num, 1); // O(1)
            if (map.get(num) > Math.floor(n/2)) {
                ret = num;
                break;
            }
        }
        return ret;
    }
}
