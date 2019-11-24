package LeetCode.Easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight
{

    public static void main(String[] args)
    {
        int[] stones = {2,7,4,1,8,1};

        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones)
    {
        // reverse order to make it a max heap.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) // put all the stones into a reverse priority queue (a max heap)
            priorityQueue.add(stone);

        while (priorityQueue.size() >= 2) // while stones can be smashed
        {
            int x = priorityQueue.poll(), y = priorityQueue.poll();

            if (x != y)
                priorityQueue.add(Math.abs(y - x)); // only one stone was broken so put it back into the pq.
        }

        if (priorityQueue.size() == 1)
            return priorityQueue.poll();
        return 0;
    }
}
