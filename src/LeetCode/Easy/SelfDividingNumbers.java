package LeetCode.Easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        List<Integer> list = selfDividingNumbers(11, 22);
        System.out.println(list);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (selfDividing(num)) {
                list.add(num);
            }
        }

        return list;
    }

    public static boolean selfDividing(int num) {
        int temp = num, denominator;
        while (temp != 0)
        {
            denominator = temp % 10;
            temp /= 10;

            if (denominator != 0) { // if the denominator isn't 0
                if (!(num % denominator == 0)) // if it's not divisible
                    return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
