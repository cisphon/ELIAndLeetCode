package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        String input1 = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(input1));
//        String input2 = "bbbbb";
//        System.out.println(lengthOfLongestSubstring(input2));
        String input3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(input3));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int longestSubstring = 0;
        String substring = "";
        for (int i = 0, j = i + 1; i < s.length() - 1 && j < s.length();) {
            substring = s.substring(i, j);
            char last = substring.charAt(substring.length() - 1);
            if (set.contains(last)) {
                set.clear();
                if (substring.length() - 1 > longestSubstring) {
                    longestSubstring = substring.length() - 1;
                }
                j = ++i;
            }
            else {
                set.add(last);
            }
            ++j;
        }

        return longestSubstring;
    }
}