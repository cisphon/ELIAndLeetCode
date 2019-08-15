package LeetCode.Easy;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new TreeMap<>(); // Order matters so I'm using a Tree.

        for (int i = 0; i < s.length(); ++i) {
            char character = s.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        Iterator<Map.Entry<Character,Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry<Character, Integer> e = iter.next();
            char c = e.getKey();
            int i = e.getValue();
            System.out.println(c + " " + i);
        }

        return 1;
    }
}
