package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

import static LeetCode.Tools.printArray;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        List<String> list = commonChars(A);
        printArray(list);
    }

    public static List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        // Common characters dictionary
        int[] dict = new int[26];
        for (int j = 0; j < A[0].length(); j++) // populate the dict with the number of chars in the first string
            dict[A[0].charAt(j) - 'a']++; // 'a' - 'a' == 0, 'b' - 'a' == 1, etc.

        for (int i = 1; i < A.length; i++) { // for the rest of the strings
            // Dictionary of the current word
            int[] curr = new int[26];
            for (int j = 0; j < A[i].length(); j++)
                curr[A[i].charAt(j) - 'a']++;

            // Update the common dictionary
            for (int j = 0; j < dict.length; j++)
                if (curr[j] < dict[j])
                    dict[j] = curr[j]; // if the occurrences are smaller, make the dict smaller.
        }
        for (int i = 0; i < dict.length; i++)
            for (int j = 0; j < dict[i]; j++)
                ans.add(Character.toString((char) ('a' + i)));
        return ans;
    }
}