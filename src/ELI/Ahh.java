package ELI;

public class Ahh
{
    public static void main(String[] args)
    {
        int[][] ass = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};

        for (int c = 0; c < ass[0].length; ++c)
        {
            for (int r = 0; r < ass.length; ++r)
            {
                System.out.println(ass[r][c]);
            }
        }
    }
}