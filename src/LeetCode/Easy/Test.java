package LeetCode.Easy;

import static LeetCode.Tools.OCDPrintArray;

public class Test {
    public static void main(String[] args) {
        int[] stuff = {3,1,2};
        int[] numbers = twoSum();
        System.out.println(OCDPrintArray(numbers));
    }

    public static int[] twoSum() {
        return new int[] {1, 2, 3, 5, 4};
    }
}