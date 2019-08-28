package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {
    public static void main(String[] args) {
        String text = "we will we will rock you";
        String first = "we", second = "will";
        String[] output = findOccurrences(text, first, second);

        for (String word : output)
            System.out.print(word + " ");
        System.out.println();
    }

    public static String[] anotherWay(String text, String first, String second) {
        String[] words = text.split(" ");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length - 2; ++i) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                list.add(words[i + 2]);
            }
        }

        return list.toArray(new String[0]); // returns a String[]
    }

    // I solved this one myself.
    public static String[] findOccurrences(String text, String first, String second) {
        String[] words = text.split(" ");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length - 2; ++i) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                list.add(words[i + 2]);
            }
        }

        String[] output = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            output[i] = list.get(i);
        }

        return output;
    }
}
