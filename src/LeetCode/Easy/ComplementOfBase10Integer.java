package LeetCode.Easy;

public class ComplementOfBase10Integer {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(bitwiseComplement(5));
    }

    public static int anotherSolution(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return N ^ X;
    }

    public static int bitwiseComplement(int N) {
        int val = Integer.highestOneBit(N) + 1;
        int val2 = Integer.highestOneBit(N) << 1;
        System.out.println(Integer.toBinaryString(val));
        System.out.println(Integer.toBinaryString(val2));

        return 1;
    }
}
