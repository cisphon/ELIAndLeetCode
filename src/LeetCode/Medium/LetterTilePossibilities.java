package LeetCode.Medium;

public class LetterTilePossibilities
{
    public static void main(String[] args)
    {
        int possiblities = numTilePossiblities("AAABBC");
        System.out.println(possiblities);
    }

    static int numTilePossiblities(String tiles)
    {
        int[] letters = new int[26]; // letters[0] = 'A'

        for (char c : tiles.toCharArray()) // increments the number of letters of a given letter.
            ++letters[c - 'A'];

        return dfs(letters);
    }

    static int dfs(int[] arr) // this doesn't keep track of the sequences.
    {
        int sum = 0;
        for (int i = 0; i < arr.length; ++i)
        {
            if (arr[i] != 0) // if a letter exists
            {
                ++sum; // increment the number of permutations

                --arr[i]; // remove the count for the next recursive call.
                sum += dfs(arr);

                ++arr[i]; // adds the count back.
            }
        }
        return sum;
    }
}