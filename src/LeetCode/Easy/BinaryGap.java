package LeetCode.Easy;

public class BinaryGap {
    public static void main(String[] args) {
        int input = 6;
        System.out.println(andAnotherSolution(input));
    }

    public static int binaryGap(int N) {
        String bin = Integer.toBinaryString(N);
        if (bin.length() == 1)
            return 0;

        char prev = bin.charAt(0);
        int distance = 0, longest = 0;
        for (int i = 1; i < bin.length(); ++i) {
            char val = bin.charAt(i);

            if (prev == '1' && val == '0') {
                distance = 1;
            }
            if (prev == '0' && val == '0') {
                ++distance;
            }
            if (prev == '0' && val == '1') {
                ++distance;
                if (distance > longest) {
                    longest = distance;
                }
                distance = 0;
            }
            if (val == '0' && i == bin.length()){
                distance = 0;
            }
            prev = val;
        }
        return longest;
    }

    public static int anotherSolution(int N) {
        int res = 0;
        for (int d = -32; N > 0; N /= 2, d++)
            if (N % 2 == 1) { // if it's odd.
                res = Math.max(res, d);
                d = 0;
            }
        return res;
    }

    public static int andAnotherSolution(int N) {
        int max = 0;
        int pos = 0;
        int lastPos = -1;
        while (N != 0) {
            pos++;
            if ((N & 1) == 1) {
                if (lastPos != -1) {
                    max = Math.max(max, pos-lastPos);
                }
                lastPos = pos;
            }
            N >>= 1;
        }
        return max;
    }
}