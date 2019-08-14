package LeetCode.Easy;

import java.util.Stack;

public class RemoveOutermostParantheses {
    public static void main(String[] args) {
        String par = "(()())(())";

        System.out.println(removeOuterParentheses(par));
    }

    // Primitive string will have equal number of opened and closed parentheses.
    public static String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        char[] chars = S.toCharArray();

        int opened = 0;
        for (char c : chars) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
}
