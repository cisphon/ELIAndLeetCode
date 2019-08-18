package LeetCode.Easy;

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        String test = "Let's take LeetCode contest";
        System.out.println(reverseWords(test));
    }

    public static String reverseWords(String s) {
        String[] tokens = s.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tokens.length; ++i) {
            stringBuilder.append(anotherOne(tokens[i]) + " ");
        }

        String ans = stringBuilder.toString();
        return ans.trim(); // removes the left and right whitespace.
    }

    // this one is faster. it's 4ms.
    private static String anotherOne(String s) {
        StringBuilder stringBuilder = new StringBuilder(s).reverse();
        return stringBuilder.toString();
    }

    // this one is 6ms
    private static String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
