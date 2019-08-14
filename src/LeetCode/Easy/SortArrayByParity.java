package LeetCode.Easy;

import java.util.*;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] input = {3,1,2,4};
        int[] output = anotherOne(input);
        for (int value : output) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int[] anotherOne(int[] A) {
        if(A == null) // corner case
            return null;
        if(A.length == 0 || A.length == 1) // corner case
            return A;

        int lo = 0, hi = A.length - 1;

        // iteratively swaps lo and hi with evens on the left and odds on right
        while(lo < hi && (lo < A.length && hi >= 0))
        {
            while(lo < A.length && A[lo] % 2 == 0) // while A[lo] is even and not the end
            {
                lo++;
            }
            while(hi > 0 && A[hi] % 2 != 0) // while A[hi] is odd and not the beginning
            {
                hi--;
            }
            if(hi < lo) { // there is no point in hi < lo for swapping.
                break;
            }
            swap(A, lo, hi);
        }
        return A;
    }

    public static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int[] sortArrayByParity(int[] A) { // O(2n) == O(n)
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        int[] evenOdd = new int[A.length];

        for (int value : A) {
            if (value % 2 == 0) { // even
                even.add(value); // O(1)
            } else { // odd
                odd.add(value);
            }
        }


        Iterator<Integer> iterator = even.iterator();

        int index = 0;
        while (iterator.hasNext()) {
            evenOdd[index++] = iterator.next();
        }

        iterator = odd.iterator();
        while (iterator.hasNext()) {
            evenOdd[index++] = iterator.next();
        }

        return evenOdd;
    }
}