package LeetCode.Medium;

import static LeetCode.Tools.printArray;

public class CountingBits
{
    public static void main(String[] args)
    {

//        int[] numBits = countBits(20);
//        printArray(numBits);

        int num = 32;
//        int dist = (int) Math.log10()

        for (int i = 0; i <= 5; i++)
        {
            System.out.println(32 >> i);
        }
    }

    public static int[] countBits(int num)
    {
        int[] n = new int[num + 1];
        for (int i = 1; i <= num; i++)
            n[i] = n[i >> 1] + (i & 1);
        return n;
    }
}
