package LeetCode.Easy;

import java.util.HashSet;

/*
* This was made on 07/4/2019 at 12:45pm.
* */

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }

        int numOfJewels = 0;

        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i))) {
                numOfJewels++;
            }
        }

        return numOfJewels;
    }
}
