package LeetCode.Easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersection = intersect(nums1, nums2);
        for (int num : intersection) {
            System.out.println(num);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) { // Incomplete
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        set1.retainAll(set2);

        int[] intersection = new int[set1.size()];

        int i = 0;
        Iterator<Integer> iter = set1.iterator();
        while (iter.hasNext())
        {
            int n = iter.next();
            intersection[i++] = n;
        }

        return intersection;
    }
}
