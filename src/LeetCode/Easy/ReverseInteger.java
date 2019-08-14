package LeetCode.Easy;

import java.lang.Math;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 1234567892;
        System.out.println(anotherSolution(x));
    }

    public static int reverse(int x) {
        if (x == 0)
            return 0;

        if (x > 0) {
            // the factor is determined by the length of the number using log10(x).

            int reverse = 0;
            long longReverse = 0, factor = (long) Math.pow(10, (long) Math.log10(x));

            while (x != 0) // iteratively compute the reverse of x
            {
                reverse += ((x % 10) * factor);
                longReverse += ((x % 10) * factor);
                factor /= 10;
                x /= 10;
            }

            if (reverse > 0 && reverse == longReverse) {  // if x reversed is still positive && it didn't overflow
                return reverse;
            }
        }

        if (x < 0){
            int reverse = 0;
            long longReverse = 0, factor = (long) Math.pow(10, (long) Math.log10(-(long) x));

            while (x != 0)
            {
                reverse += ((x % 10) * factor);
                longReverse += ((x % 10) * factor);
                factor /= 10;
                x /= 10;
            }

            if (reverse < 0 && reverse == longReverse) { // if x reversed is still negative and doesn't overflow
                return reverse;
            }
        }

        return 0; // it overflowed
    }

    public static int anotherSolution(int x) {
        if (x == 0)
            return 0;

        int reversed = 0;
        long longReversed = 0;

        while (x != 0) { // this computes the reverse
            reversed = 10 * reversed + x % 10; // 10 * reversed shifts it.
            longReversed = 10 * longReversed + x % 10;
            x /= 10;
        }

        if (reversed == longReversed)
            return reversed;

        return 0;
    }
}