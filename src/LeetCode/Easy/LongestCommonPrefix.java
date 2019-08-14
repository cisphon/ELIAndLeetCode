package LeetCode.Easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"abca", "abc"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String anotherSolution(String[] strs) {
        int len = strs.length;
        String result;

        if (len < 1) {
            return "";
        } else if (len == 1) {
            return strs[0];
        } else {
            result = strs[0];

            for (int i = 0; i < len; i++) { // for each str
                while (strs[i].indexOf(result) != 0) {
                    result = result.substring(0, result.length() - 1);
                }
            }

            return result;
        }
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        String common = "";
        for (int charIndex = 0; ; ++charIndex)
        {
            try {
                if (strs[charIndex].length() == 0) {
                    return common;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                ;
            }

            char first;
            try {
                first = strs[0].charAt(charIndex);
            } catch (ArrayIndexOutOfBoundsException e) {
                return common;
            } catch (StringIndexOutOfBoundsException e) {
                return common;
            }
            for (int arrayIndex = 1; arrayIndex < strs.length; arrayIndex++)
            {
                char next;
                try {
                    next = strs[arrayIndex].charAt(charIndex);
                } catch (ArrayIndexOutOfBoundsException e) {
                    return common;
                } catch (StringIndexOutOfBoundsException e) {
                    return common;
                }

                if (first != next)
                {
                    return common;
                }
            }
            common += first;
        }
    }
}
