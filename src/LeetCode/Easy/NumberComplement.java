package LeetCode.Easy;

public class NumberComplement {
    public static void main(String[] args) {
        int n = 24;
        System.out.println(Integer.toBinaryString(n));

        int highestOneBit = Integer.highestOneBit(42);
        System.out.println(Integer.toBinaryString(highestOneBit));

        int highestOneBitMinusOne = highestOneBit - 1;
        System.out.println(Integer.toBinaryString(highestOneBitMinusOne));

        System.out.println(~n & (highestOneBit - 1));
    }

    public static int findComplement(int num) { // a slow O(n) approach.
        String s = Integer.toBinaryString(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char value = s.charAt(i);
            if (value == '0')
                stringBuilder.append('1');
            else
                stringBuilder.append('0');
        }
        return Integer.parseInt(stringBuilder.toString(), 2); // Parse the string as a base 2 number.
    }

    public static int bitManipulation(int num) {
        int mask = Integer.highestOneBit(num) - 1;
        num = ~num; // flips the bits.
        return num & mask;
    }
}