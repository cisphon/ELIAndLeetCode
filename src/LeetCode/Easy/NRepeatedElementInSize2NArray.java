package LeetCode.Easy;

import java.util.HashMap;

public class NRepeatedElementInSize2NArray {
    public static void main(String[] args) {
        int[] a = {4,1,5,4,5,3,5,5};
        System.out.println(repeatedNTimes(a));
    }

    public static int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int x: A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int N = A.length / 2;
        for (int k: count.keySet())
            if (count.get(k) == N)
                return k;

        throw null;
    }
}
