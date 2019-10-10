package LeetCode.Medium;

import java.util.*;

public class CarPooling
{
    public static void main(String[] args)
    {
        int[][] trips = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        boolean s = oneThousandAndOne(trips, 10);
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

    public static boolean oneThousandAndOne(int[][] trips, int capacity) // doesn't treat it like an interval.
    {
        int stops[] = new int[1001]; // 0 <= trips[i][1] < trips[i][2] <= 1000. [0, 1000] is 1001 stops.
        for (int t[] : trips) // for each trip
        {
            stops[t[1]] = stops[t[1]] + t[0];
            stops[t[2]] = stops[t[2]] - t[0];
        }
        for (int i = 0; capacity >= 0 && i < 1001; ++i)
            capacity -= stops[i];
        return capacity >= 0;
    }

    public static boolean meetingRoomsIII(int[][] trips, int capacity)
    {
        Map<Integer, Integer> m = new TreeMap<>();
        for (int[] t : trips)
        {
            m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);
            m.put(t[2], m.getOrDefault(t[2], 0) - t[0]);
        }
        for (int v : m.values())
        {
            capacity -= v;
            if (capacity < 0)
                return false;
        }
        return true;
    }

    public static boolean sortAndPriorityQueue(int[][] trips, int capacity)
    {
        Arrays.sort(trips, Comparator.comparing(trip -> trip[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(trip -> trip[2]));
        for (int[] trip : trips)
        {
            while (!pq.isEmpty() && trip[1] >= pq.peek()[2]) // any passengers need to get off?
                capacity += pq.poll()[0]; // more capacity as passengers out.
            capacity -= trip[0]; // less capacity as passengers in.
            if (capacity < 0) return false; // not enough capacity.
            pq.offer(trip); // put into PriorityQueue the infomation at current location.
        }
        return true;
    }
}
