package LeetCode.Easy;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String s = "ZY";
        System.out.println(titleToNumber(s));
    }

    public static int titleToNumber(String s) { // O(n)
        int sum = 0;
        for (int i = s.length() - 1, pow = 0; i >= 0; --i, ++pow) {
            char character = s.charAt(i);
            int value = charToInt(character);
            sum += (Math.pow(26, pow) * value);
        }
        return sum;
    }

    public static int charToInt(char c) {
        switch(c)
        {
            case 'A': return 1;
            case 'B': return 2;
            case 'C': return 3;
            case 'D': return 4;
            case 'E': return 5;
            case 'F': return 6;
            case 'G': return 7;
            case 'H': return 8;
            case 'I': return 9;
            case 'J': return 10;
            case 'K': return 11;
            case 'L': return 12;
            case 'M': return 13;
            case 'N': return 14;
            case 'O': return 15;
            case 'P': return 16;
            case 'Q': return 17;
            case 'R': return 18;
            case 'S': return 19;
            case 'T': return 20;
            case 'U': return 21;
            case 'V': return 22;
            case 'W': return 23;
            case 'X': return 24;
            case 'Y': return 25;
            case 'Z': return 26;
        }
        return -1; // DNE
    }
}
