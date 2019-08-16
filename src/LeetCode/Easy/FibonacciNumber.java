package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
    private static int[] fib_cache1 = new int[31];
    private static int[] fib_cache2 = new int[31];

    public static void main(String[] args) {
        int val = 30;
        System.out.println(fib(val));
    }

    public static int fib(int N) {
        if (N == 0 || N == 1)
            return N;
        return fib(N - 1) + fib(N - 2);
    }

    public static int fibIterative(int N) {
        if(N <= 1)
            return N;

        int a = 0, b = 1;

        while(N-- > 1)
        {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static int DPTopDown(int N) {
        if(N <= 1)
            return N;
        else if(fib_cache1[N] != 0)
            return fib_cache1[N];
        else
            return fib_cache1[N] = fib(N - 1) + fib(N - 2);
    }

    public static int DPBottomUp(int N) {
        if(N <= 1)
            return N;

        int[] fib_cache2 = new int[N + 1];
        fib_cache2[1] = 1;

        for(int i = 2; i <= N; i++)
        {
            fib_cache2[i] = fib_cache2[i - 1] + fib_cache2[i - 2];
        }
        return fib_cache2[N];
    }
}
