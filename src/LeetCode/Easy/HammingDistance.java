package LeetCode.Easy;

public class HammingDistance {
    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        int result = x ^ y;
        String binary = Integer.toBinaryString(result);
        int differences = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                differences++;
            }
        }

        return differences;
    }
}
