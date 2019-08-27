package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {
    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";

        System.out.println(calculateTime(keyboard, word));
    }

    public static int mapApproach(String keyboard, String word) {
        if(word.length() == 1) return keyboard.indexOf(word);

        // Convert keyboard to map for quick lookup
        Map<Character, Integer> keyboardMap = new HashMap<>();
        for(int i = 0; i < keyboard.length(); i++) { keyboardMap.put(keyboard.charAt(i), i); }

        // Initialize time variables
        int totalTime = keyboardMap.get(word.charAt(0)), iterTime = 0;

        // Find time taken for each keystroke
        for(int i = 1; i < word.length(); i++) {
            int currChar = keyboardMap.get(word.charAt(i-1));
            int nextChar = keyboardMap.get(word.charAt(i));
            totalTime += ((iterTime = nextChar - currChar) < 0 ? (-1 * iterTime) : iterTime);
        }

        return totalTime;
    }

    public static int bucketApproach(String keyboard, String word) {
        //fill mapping for the keyboard chars and indexes
        int[] index = new int[26];
        for (int i = 0; i < keyboard.length(); ++i)
        {
            index[keyboard.charAt(i) - 'a'] = i; // 'a' - 'a' = 0, 'b' - 'a' = 1, etc.
        }

        int sum = 0, last = 0;
        for (char c : word.toCharArray())
        {
            sum += Math.abs(index[c - 'a'] - last);
            last = index[c - 'a'];
        }

        return sum;
    }

    // Solved this one myself.
    public static int calculateTime(String keyboard, String word) {
        int start = 0, time = 0;
        boolean found = false;
        for (char c : word.toCharArray())
        {
            int index = start;
            while (index < keyboard.length()) // check to the right of the start
            {
                if (c == keyboard.charAt(index)) {
                    time += Math.abs(start - index);
                    found = true;
                    break;
                }
                ++index;
            }

            if (!found) {
                index = start;
                while (index >= 0) // check to the left of the index
                {
                    if (c == keyboard.charAt(index)) {
                        time += Math.abs(start - index);
                        found = true; // not necessary but still good practice.
                        break;
                    }
                    --index;
                }
            }
            found = false;
            start = index;
        }

        return time;
    }
}
