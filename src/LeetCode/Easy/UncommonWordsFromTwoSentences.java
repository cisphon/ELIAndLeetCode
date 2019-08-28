package LeetCode.Easy;

import java.util.*;

public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";
        String[] words = uncommonFromSentences(A, B);
        for (String word : words)
            System.out.println(word);
    }

    public static String[] anotherSolution(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String w : (A + " " + B).split(" ")) // this allows you to process A and B at the same time.
            count.put(w, count.getOrDefault(w, 0) + 1);

        ArrayList<String> res = new ArrayList<>();
        for (String w : count.keySet())
            if (count.get(w) == 1)
                res.add(w);
        return res.toArray(new String[0]);
    }

    // I solved this one by myself.
    public static String[] uncommonFromSentences(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String wordA : wordsA) // for each word
            map.put(wordA, map.getOrDefault(wordA, 0) + 1); // put the word, number of occurrences.
        for (String wordB : wordsB) // for each word
            map.put(wordB, map.getOrDefault(wordB, 0) + 1); // put the word, number of occurrences.

        List<String> list = new ArrayList<>();
        for (String key : map.keySet())
            if (map.get(key) == 1)
                list.add(key);

        return list.toArray(new String[0]);
    }
}
