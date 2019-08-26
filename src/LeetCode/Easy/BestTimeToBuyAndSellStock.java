package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    // this problem is the same as "max subarray problem"
    public static int kadanesAlgorithm(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int price: prices) {
            min = Math.min(min, price);
            max = Math.max(price - min, max);
        }
        return max;
    }

    // this is a slow O(N^2) approach.
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;

        int i;
        for (i = 0; i < prices.length - 1; ++i) {
            if (prices[i] > prices[i + 1]) { // while the price is decreasing
                continue;
            } else {
                break;
            }
        }

        int biggestProfit = 0;
        for (int j = i; j < prices.length - 1; ++j) {
            for (int k = j + 1; k < prices.length; ++k) {
                int profit = prices[k] - prices[j];
                if (biggestProfit < profit)
                    biggestProfit = profit;
            }
        }

        return biggestProfit;
    }
}
