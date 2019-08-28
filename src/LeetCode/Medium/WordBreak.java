package LeetCode.Medium;

import java.lang.reflect.Array;
import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> list = Arrays.asList("aaa", "aaaa");
        System.out.println(wordBreak(s, list));
    }

    public static boolean dynamicProgramming1(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) // add every word from the list into the dictionary.
            dict.add(word);

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        // First DP
        for(int i = 1; i <= s.length(); i++) {
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[s.length()];
    }

    public static boolean dynamicProgramming2(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) // add every word from the list into the dictionary.
            dict.add(word);

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        // Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    // I couldn't get this one to work for all the test cases.
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) // this will make indexing the word in O(1) runtime.
            set.add(word);

        int i = 0, j = i + 1;
        while(j <= s.length()) {
            String substring = s.substring(i, j);

            if (set.contains(substring)) {
                if (j == s.length()) // if set contains the substring and it's the last index, all of the words fit.
                    return true;
                i = j;
            }
            ++j;
        }
        return false;
    }
}
