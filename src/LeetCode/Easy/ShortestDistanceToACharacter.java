package LeetCode.Easy;

import static LeetCode.Tools.printArray;

public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';

        int[] arr = shortestToChar(S, C);
        printArray(arr);
    }

    // This solution was pretty fast. it's faster than 98.66% of the solutions
    public static int[] shortestToChar(String S, char C) {
        int[] nums = new int[S.length()];
        for (int i = 0; i < S.length(); ++i) // initialize the entire array with -1
            nums[i] = -1;

        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == C) {
                nums[i] = 0;

                int j = i - 1, distLeft = 1;
                while (j >= 0 && S.charAt(j) != C) // place the distances to the left from index i.
                {
                    if (nums[j] > distLeft || nums[j] == -1) { // distance is greater than current or never visited
                        nums[j--] = distLeft++;
                    } else {
                        break;
                    }
                }

                int k = i + 1, distRight = 1;
                while (k < S.length() && S.charAt(k) != C)
                {
                    if (nums[k] > distRight || nums[k] == -1) {
                        nums[k++] = distRight++;
                    } else {
                        break;
                    }
                }
            }
        }

        return nums;
    }
}