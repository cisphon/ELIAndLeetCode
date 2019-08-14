package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int prev = getValue(s.charAt(s.length() - 1));
        int sum = prev;

        for (int i = s.length() - 2; i >= 0; --i) // start from the right side.
        {
            char current = s.charAt(i);
            int value = getValue(current);

            if (value >= prev)
            {
                sum += value;
                prev = value;
            } else {
                sum -= value;
                prev = value;
            }
        }

        return sum;
    }

    private static int getValue(char c) {
        switch (c)
        {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        throw new IllegalArgumentException();
    }
}
