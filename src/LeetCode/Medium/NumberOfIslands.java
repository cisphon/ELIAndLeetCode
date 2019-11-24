package LeetCode.Medium;

public class NumberOfIslands
{

    public static void main(String[] args)
    {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid1));
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid2));
    }

    // I knew that DFS and possibly union-find would
    // be apart of the problem, but had no clue how to solve it.
    public static int numIslands(char[][] grid)
    {
        // O(n^2) time.
        // not initialized or no rows or no columns in row 0
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int numIslands = 0;
        for (int i = 0; i < grid.length; ++i)
        {
            for (int j = 0; j < grid[i].length; ++j)
            {
                if (grid[i][j] == '1')
                { // if it's an island.
                    numIslands += dfs(grid, i, j); // dfs is a kind of backtracking
                }
            }
        }
        return numIslands;
    }

    // this uses the method call stack for the DFS stack.
    public static int dfs(char[][] grid, int i, int j)
    {
        // if out of bounds of the matrix or if the character is water
        if ((i < 0 || i >= grid.length) || (j < 0 || j >= grid[i].length) || grid[i][j] == '0')
            return 0; // no longer traversing.

        grid[i][j] = '0'; // we are sinking the island.

        dfs(grid, i - 1, j); // up neighbor
        dfs(grid, i + 1, j); // down neighbor
        dfs(grid, i, j - 1); // left neighbor
        dfs(grid, i, j + 1); // right neighbor

        return 1; // after sinking all the neighbors, return 1 to account for the original island.
    }
}