package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "ra";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for (int i = 0; i < s.length(); ++i) {
                char a = s.charAt(i);
                if (map1.containsKey(a)) {
                    map1.replace(a, map1.get(a) + 1);
                } else {
                    map1.put(a, 1);
                }

                char b = t.charAt(i);
                if (map2.containsKey(b)) {
                    map2.replace(b, map2.get(b) + 1);
                } else {
                    map2.put(b, 1);
                }
            }
            boolean map1ContainsMap2 = map1.entrySet().containsAll(map2.entrySet());
            boolean map2ContainsMap1 = map2.entrySet().containsAll(map1.entrySet());
            return map1ContainsMap2 && map2ContainsMap1;
        } else {
            return false;
        }
    }

    // It increments the bucket value with String s and decrement with string t.
    // So if they are anagrams, all buckets should remain with initial value which is zero.
    public static boolean bucket(String s, String t) {
        int[] alphabet = new int[26]; // 26 because there are 26 letters in english
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            if(alphabet[t.charAt(i) - 'a'] < 0) return false;
        }
        for (int i : alphabet)
            if (i != 0) return false;
        return true;
    }
}
