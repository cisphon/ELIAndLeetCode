package LeetCode.Easy;

public class PeakIndexInAMountainArray {

    public static void main(String[] args) {
        int[] array = new int[]{0, 2, 1, 0};
        System.out.println(binarySearch(array));
    }

    // Time Complexity: O(log n), where N is length of A
    // Space Complexity: O(1)
    public static int linearScan(int[] A) {
        int i = 0;
        while(A[i] < A[i+1]) { // while still increasing
            i = i + 1;
        }
        return i;
    }

    // Time Complexity: O(log N), where N is length of A
    // Space Complexity: O(1)
    public static int binarySearch(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
}
