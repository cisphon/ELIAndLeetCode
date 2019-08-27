package LeetCode.Easy;

import java.util.*;

public class HighFive {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(5);

    }

    public static int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>(); // this priority queue uses balanced binary heap

        for (int[] item: items) { // for each item
            int ID = item[0]; // obtain the ID
            int score = item[1]; // obtain the score

            if (!map.containsKey(ID)) { // if the ordered map doesn't have the ID
                PriorityQueue<Integer> pq = new PriorityQueue<>(5); // initialize a PQ with capacity of 5.
                pq.offer(score); // add throws an exception. offer doesn't.
                map.put(ID, pq);
            } else {
                PriorityQueue<Integer> pq = map.get(ID);
                pq.offer(score);
                if (pq.size() > 5)
                    pq.poll(); // removes the smallest element.
                map.put(ID, pq);
            }
        }


        int[][] res = new int[map.size()][2]; // num of rows = size of the map, num of cols = 2 (ID and score).

        int index = 0;
        for (int id : map.keySet()) // for each key in the map
        {
            res[index][0] = id; // place the id in the array.

            PriorityQueue<Integer> pq = map.get(id);

            int sum = 0, numElements = pq.size();
            while (!pq.isEmpty())
            {
                sum += pq.poll(); // retrieves and removes the head of the pq.
            }

            res[index][1] = sum / numElements; // computes the average using integer division.

            ++index;
        }

        return res;
    }
}
