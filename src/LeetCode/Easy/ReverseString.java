package LeetCode.Easy;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        printCharArray(s);
    }

    public static void reverseString(char[] s) {
        for (int lo = 0, hi = s.length - 1; lo < s.length && hi >= 0; lo++, hi--) {
            if (lo < hi) { //
                swap(s, lo, hi);
            }
        }
    }

    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void printCharArray(char[] s) {
        for (char c : s) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
