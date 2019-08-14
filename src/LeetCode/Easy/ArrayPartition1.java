package LeetCode.Easy;

import java.util.Arrays;

import static LeetCode.Tools.printArray;

public class ArrayPartition1 {
    public static void main(String[] args) {
        int[] nums = {4,3,1,2};
//        System.out.println(countingAlgorithm(nums));
    }

    // Time Complexity: O(n)
    public static int countingAlgorithm(int[] nums) {
        // counting sort algorithm
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[nums.length];
        int sum = 0, p = 0;

        // for each index, increment the count of occurence of the element in that index
        for (int i = 0; i < nums.length; i++)
        {
            count[nums[i] - min]++;
        }

        // copying the elements based on occurence into other array
        for(int i=0;i<count.length;i++)
        {
            while(count[i]>0)
            {
                output[p++] = min + i;
                count[i]--;
            }

        }

        // main logic for the problem description
        // taking the first element of each pair in the array since in sorted array,
        // the first element of the pair would be minimum
        for(int i = 0; i < output.length; i++){
            if(i % 2 == 0){
                sum += output[i];
            }
        }
        return sum;
    }

    // Time Complexity: O(n * log(n))
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums); // O(n * log(n))

        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) { // O(n/2) = O(n)
                sum += Math.min(nums[i], nums[i + 1]);
        }

        return sum;
    }
}
