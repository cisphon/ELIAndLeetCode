package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int input = 19;
        System.out.println(isHappy(input));
    }

    // this solution is slower because of the "visited" function calls.
    // compared to the similar solution below this one.
    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (!visited.contains(n)) // while at a number not visited
        {
            visited.add(n);

            int sum = 0;
            while (n != 0)
            {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;

            if (n == 1) return true;
        }
        return false;
    }

    // this one is the same idea as mine but it's over 30% faster.
    public static boolean anotherSolution(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum,remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;

    }
}
