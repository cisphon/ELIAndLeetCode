package LeetCode.Easy;

import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        String s = "abc";
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedWords = new ArrayList<>();
        for (String word : banned)
            bannedWords.add(word);
        Collections.sort(bannedWords); // bannedWords must be sorted to be able to use binary search.

        Map<String, Integer> occurences = new HashMap<>();
        String[] tokens = paragraph.split(" ");
        for (String token : tokens)
        {
            int length = token.length();

            if (token.charAt(length - 1) == ',')
                token = token.substring(0, length - 1); // remove the last character
            token = token.toLowerCase();

//            Collections.binarySearch(token, bannedWords);

        }

        return "";
    }
}
