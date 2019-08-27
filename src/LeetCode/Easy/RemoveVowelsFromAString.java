package LeetCode.Easy;

public class RemoveVowelsFromAString {
    public static void main(String[] args) {
        String input = "leetcodeisacommunityforcoders";

        System.out.println(removeVowels(input));
    }

    // here's my first solution.
    public static String removeVowels(String S) {
        return S.replaceAll("[aeiou]", "");
    }
}
