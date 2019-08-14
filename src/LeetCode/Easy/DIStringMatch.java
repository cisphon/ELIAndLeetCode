package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static LeetCode.Tools.printArray;

public class DIStringMatch {
    public static void main(String[] args) {
        String directions = "DDI";
        int[] a = diStringMatch(directions);
        printArray(a);
    }

    public static int[] diStringMatch(String S) {
        int[] ans = new int[S.length() + 1];
        int max = S.length();
        int min = 0;

        int i = 0; // index
        for (char c : S.toCharArray()) { // iterate over each character in S
            if (c == 'I') {
                ans[i] = min;
                min++;
            } else if (c == 'D') {
                ans[i] = max;
                max--;
            }
            i++;
        }

        if (S.endsWith("I")) {
            ans[i] = ans[i - 1] + 1; // next num = previous num + 1
        } else if (S.endsWith("D")) {
            ans[i] = ans[i - 1] - 1; // next num = previous num - 1
        }

        return ans;
    }
}