package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(tribonacci(n));
    }

    public static Map<Integer, Integer> map = new HashMap<>();
    public static int tribonacci(int n) {
        if (map.containsKey(n))
            return map.get(n);
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        map.put(n, tribonacci(n-3) + tribonacci(n - 2) + tribonacci(n - 1));
        return map.get(n);
    }
}
