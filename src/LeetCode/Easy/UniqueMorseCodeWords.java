package LeetCode.Easy;

import java.util.HashSet;

public class UniqueMorseCodeWords {

    static String[] conversions ={".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."};

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig"};

        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        HashSet<String> transformations = new HashSet<>();

        for (String word : words) {
            transformations.add(convert(word));
        }

        return transformations.size();
    }

    public static String convert(String word) {
        char[] values = word.toCharArray();

        String conversion = "";

        for (int i = 0; i < values.length; i++) {
            char currentChar = values[i];
            conversion += conversions[(int) currentChar - 97];
        }

        return conversion;
    }
}
