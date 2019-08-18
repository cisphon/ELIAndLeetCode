package LeetCode.Easy;

import static LeetCode.Easy.ReverseString.swap;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(anotherSolution(s1));

        String s2 = "leetcode";
        System.out.println(anotherSolution(s2));

        String s3 = "aA";
        System.out.println(anotherSolution(s3));
    }

    // here's a much faster solution based on the same two pointer approach
    public static String anotherSolution(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();

        int lo = 0, hi = s.length() - 1;
        while (lo < hi )
        {
            while(lo < hi && !vowels.contains("" + chars[lo]))
                ++lo;

            while(lo<hi && !vowels.contains("" + chars[hi]))
                --hi;

            swap(chars, lo, hi);
            ++lo;
            --hi;
        }
        return new String(chars);
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // I see a two pointer approach, it's 65ms. pretty slow.
    public static String reverseVowels(String s) {
        StringBuilder stringBuilder = new StringBuilder(s); // this allows for mutability.

        int lo = 0, hi = s.length() - 1;
        while (lo < hi)
        {
            char left = stringBuilder.charAt(lo);
            if (!isAVowel(left))
                ++lo;

            char right = stringBuilder.charAt(hi);
            if (!isAVowel(right))
                --hi;

            if (isAVowel(left) && isAVowel(right)) {
                swap(stringBuilder, lo, hi);
                ++lo;
                --hi;
            }
        }
        return stringBuilder.toString();
    }

    public static void swap(StringBuilder s, int lo, int hi) {
        char temp = s.charAt(lo);
        s.replace(lo, lo + 1, "" + s.charAt(hi));
        s.replace(hi, hi + 1, "" + temp);
    }

    public static boolean isAVowel(char c) {
        switch(c)
        {
            case 'A': return true;
            case 'a': return true;

            case 'E': return true;
            case 'e': return true;

            case 'I': return true;
            case 'i': return true;

            case 'O': return true;
            case 'o': return true;

            case 'U': return true;
            case 'u': return true;
        }
        return false;
    }
}