package LeetCode.Medium;

import static LeetCode.Tools.printArray;

public class CountingBits {
    public static void main(String[] args) {
        int[] numBits = countBits(20);
        printArray(numBits);
    }

    public static int[] countBits(int num) {
        int[] n = new int[num + 1];
        for (int i = 1; i <= num; i++)
            n[i] = n[i >> 1] + (i & 1);
        return n;
    }
}
