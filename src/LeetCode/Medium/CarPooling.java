package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class CarPooling
{
    public static void main(String[] args)
    {
        int[][] trips = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        boolean s = carPooling(trips, 10);
        System.out.println(s);
    }

    // this works but it's slow.
    public static boolean carPooling(int[][] trips, int capacity)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < trips.length; ++r)
        {
            int passengers = trips[r][0];
            for (int c = trips[r][1]; c < trips[r][2]; ++c)
            {
                int val = map.getOrDefault(c, 0);
                if (val + passengers > capacity)
                    return false;
                else
                    map.put(c, val + passengers);
            }
        }
        return true;
    }

    public static boolean faster(int[][] trips, int capacity)
    {
        int stops[] = new int[1001];
        for (int t[] : trips)
        {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
        return capacity >= 0;
    }
}
