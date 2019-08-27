package LeetCode.Easy;

public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(2));
    }

    // I produced this solution by myself.
    public static boolean isArmstrong(int N) {
        int length = (int) Math.log10(N) + 1, sum = 0, temp = N;
        while (temp != 0)
        {
            sum += (int) Math.pow((temp % 10), length);
            temp /= 10;
        }
        return sum == N;
    }
}
