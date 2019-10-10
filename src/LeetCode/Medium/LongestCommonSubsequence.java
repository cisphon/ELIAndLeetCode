package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LongestCommonSubsequence
{
    public static void main(String[] args)
    {
        String a = "psnw", b = "vozsh";
        System.out.println(solution1(a, b));
    }

    // Time & Space complexity: O(m * n)
    public static int solution1(String s1, String s2)
    {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); ++i)
            for (int j = 0; j < s2.length(); ++j)
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                else
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        return dp[s1.length()][s2.length()];
    }

    // Time complexity: O(m * n)
    // Space complexity: O(min(m, n))
    public static int solution2(String s1, String s2)
    {
        int m = s1.length(), n = s2.length();
        if (m < n)  return solution2(s2, s1); // recall the method with reversed inputs.

        int[][] dp = new int[2][n + 1];
        for (int i = 0, k = 1; i < m; ++i, k ^= 1)
            for (int j = 0; j < n; ++j)
                if (s1.charAt(i) == s2.charAt(j))
                    dp[k][j + 1] = 1 + dp[k ^ 1][j];
                else
                    dp[k][j + 1] = Math.max(dp[k ^ 1][j + 1], dp[k][j]);
        return dp[m % 2][n];
    }
}
