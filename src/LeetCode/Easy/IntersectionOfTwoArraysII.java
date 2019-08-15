package LeetCode.Easy;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersection = intersect(nums1, nums2);
    }

    public static int[] intersect(int[] nums1, int[] nums2) { // O(N * log N)
        Arrays.sort(nums1); // 1,1,2,2
        Arrays.sort(nums2); // 2,2

        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            int val1 = nums1[i], val2 = nums2[j];
            if (val1 < val2) {
                ++i;
            } else if (val1 > val2) {
                ++j;
            } else { // val1 == val2
                list.add(val1);
                ++j;
                ++i;
            }
        }

        int[] intersection = new int[list.size()];
        for (int i = 0; i < intersection.length; ++i) {
            intersection[i] = list.get(i).intValue();
        }

        return intersection;
    }

    public static int[] anotherSolution(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            r[i] = result.get(i);
        }

        return r;
    }
}
