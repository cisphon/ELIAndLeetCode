package LeetCode.Easy;

public class PowerOfTwo {
    public static void main(String[] args) {
        int val = 1073741824;
        while (val != 0)
        {
            System.out.println(val + " " + isPowerOfTwo(val));
            val /= 2;
        }
    }

    // I made this solution myself.
    public static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        long val = (Long.highestOneBit((long) n) << 1);
        return val >> 1 == n;
    }

    // I had the same idea, I just didn't that bitCount existed.
    public static boolean anotherSolution(int n) {
        if (n < 0)
            return false;
        return Integer.bitCount(n) == 1;
    }
}