package LeetCode.Easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 1;
        System.out.println(x << 31 ^ ~(x << 31));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) // apparently x cannot be palindrome if it's negative.
            return false;

        int length = (int) Math.log10(x) + 1;
        if (length == 1) // x must be at least 2 length.
            return true;


        int distance = (int) Math.ceil(Math.log10(x)) / 2;

        int reverse = 0, factor = (int) Math.pow(10, distance - 1);
        for (int i = 1; i <= distance; i++) { // compute the reverse of the right half of x.
            reverse += ((x % 10) * factor);
            x /= 10;
            factor /= 10;
        }

        if (length % 2 != 0) // truncate the middle integer
            x /= 10;

        if (x == reverse) // the left and reversed right halves are the same (palindrome)
            return true;

        return false; // not a palindrome
    }

    public static boolean anotherSolution(int x) {
        if (x < 0) return false; // if negative
        if (x < 10) return true; // if 0-9

        int reversed = 0;
        int temp = x;
        while (temp != 0)
        {
            reversed = 10 * reversed + temp % 10; // 10 * reversed shifts it.
            temp /= 10;
        }

        return x == reversed;
    }
}
