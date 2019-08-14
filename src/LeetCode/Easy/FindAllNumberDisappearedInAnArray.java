package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumberDisappearedInAnArray {
    public static void main(String[] args) {
        int[] array = {1,1,2};

        List<Integer> list = geniusSolution(array);
        System.out.println(list);
    }

    public static List<Integer> geniusSolution(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int val = Math.abs(nums[i]) - 1; // subtract 1 to make it index properly.
            if (nums[val] > 0) // if not negative (it's not seen before)
                nums[val] = -nums[val]; // make it negative (it's now seen)
        }

        for(int i = 0; i < nums.length; i++)
            if(nums[i] > 0) // if not negative (it's not seen before)
                ret.add(i+1); // add index plus 1.
        return ret;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) { // slow AF
        int length = nums.length;

        Set<Integer> doNotAppear = new HashSet<>();
        for (int i = 1; i <= length; i++) {
            doNotAppear.add(i);
        }

        for (Integer num : nums) {
            if (doNotAppear.contains(num)) {
                doNotAppear.remove(num);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Integer integer : doNotAppear) {
            list.add(integer);
        }

        return list;
    }
}
