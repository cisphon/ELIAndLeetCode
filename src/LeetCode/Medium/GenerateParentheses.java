package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

import static LeetCode.Tools.printArray;

public class GenerateParentheses
{
    public static void main(String[] args)
    {
        int n = 10;
        int all = allPerms(n).size();
        int conditioned = approach1(n).size();
        System.out.println(all);
        System.out.println(conditioned);
        System.out.println(all / conditioned);
    }

    public static List<String> allPerms(int n)
    {
        List<String> stringList = new ArrayList<>(), temp;
        stringList.add("(");

        for (int depth = 1, end = 2 * n; depth < end; ++depth)
        {
            temp = new ArrayList<>();
            for (String string : stringList)
            {
                temp.add(string + "(");
                temp.add(string + ")");
            }
            stringList.clear();
            stringList.addAll(temp);
        }

        return stringList;
    }

    // Here is my naive permutation solution
    public static List<String> naive(int n)
    {
        List<String> stringList = new ArrayList<>(), temp;
        stringList.add("(");

        for (int depth = 1, end = 2 * n; depth < end; ++depth)
        {
            temp = new ArrayList<>();
            for (String string : stringList)
            {
                temp.add(string + "(");
                temp.add(string + ")");
            }
            stringList.clear();
            stringList.addAll(temp);
        }

        List<String> correct = new ArrayList<>();
        for (String s : stringList) // post processing (naive)
        {
            if (GenerateParentheses.validParentheses(s, n))
                correct.add(s);
        }
        return correct;
    }

    public static boolean validParentheses(String s, int n)
    {
        int numOpening = 0, numClosing = 0;
        for (char c : s.toCharArray())
        {
            if (c == '(')
                ++numOpening;
            else
                ++numClosing;
            if (numOpening < numClosing)
                return false;
            if (numOpening > n)
                return false;
        }
        return true;
    }

    // Time complexity: O(2 ^ (2N)) / sqrt(N), where N is the max number.
    // (it's not O(2^N)/sqrt(N) because it has to be max * 2 length).
    public static void backtrack(List<String> list, String str, int open, int close, int max)
    {
        if (str.length() == max * 2) // if the string is the max length
        {
            list.add(str); // return the finished string
            return;
        }

        if (open < max) // there cannot be more open parentheses than the max number of open parentheses.
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open) // there cannot be more closed parentheses than open parentheses
            backtrack(list, str + ")", open, close + 1, max);
    }

    public static List<String> approach1(int n)
    {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static List<String> approach2(int n)
    { // same as approach 1 but iterative and recursive
        List<String> ans = new ArrayList();
        if (n == 0)
        {
            ans.add("");
        }
        else
        {
            for (int c = 0; c < n; ++c)
                for (String left : approach1(c))
                    for (String right : approach1(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}