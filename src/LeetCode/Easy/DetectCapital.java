package LeetCode.Easy;

public class DetectCapital {
    public static void main(String[] args) {
        String s = "google";
        System.out.println(detectCapitalUse(s));
    }

    public static boolean detectCapitalUse(String word) { // O(n)
        boolean startIsCapital = false;
        boolean containsCapsAfterStart = false;
        boolean containsLowercase = false;
        for (int i = 0; i < word.length(); ++i) {
            char value = word.charAt(i);
            if (i == 0 && isCapital(value)) {
                startIsCapital = true;
            }
            else if (isCapital(value)) {
                containsCapsAfterStart = true;
            } else {
                containsLowercase = true;
            }
        }

        if (!startIsCapital && containsCapsAfterStart) // iNCORRECT
            return false;
        if (!containsLowercase) // CORRECT
            return true;
        if (startIsCapital && !containsCapsAfterStart) // Correct
            return true;
        if (!startIsCapital && !containsCapsAfterStart && containsLowercase) // correct
            return true;

        return false;
    }

    public static boolean isCapital(char c) {
        if ('A' <= c && c <= 'Z')
            return true;
        return false;
    }
}
