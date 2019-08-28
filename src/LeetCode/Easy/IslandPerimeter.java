package LeetCode.Easy;

public class IslandPerimeter {
    public static void main(String[] args) {

    }

    public static int anotherSolution(int[][] grid) {
        int islands = 0, neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }
        return islands * 4 - neighbours * 2; // it's just math, man.
    }

    // My solution worked but it's slow.
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[r].length; ++c) {
                if (grid[r][c] == 1) { // is an island
                    perimeter += perimeter(grid, r, c);
                }
            }
        }

        return perimeter;
    }

    public static int perimeter(int[][] grid, int r, int c) {
        int perimeter = 0;

        if (!isValidCoordinate(grid, r - 1, c)) { // check up
            ++perimeter;
        } else {
            if (grid[r - 1][c] == 0)
                ++perimeter;
        }

        if (!isValidCoordinate(grid, r + 1, c)) { // check down
            ++perimeter;
        } else {
            if (grid[r + 1][c] == 0)
                ++perimeter;
        }

        if (!isValidCoordinate(grid, r, c - 1)) { // check left
            ++perimeter;
        } else {
            if (grid[r][c - 1] == 0)
                ++perimeter;
        }

        if (!isValidCoordinate(grid, r, c + 1)) { // check right
            ++perimeter;
        } else {
            if (grid[r][c + 1] == 0)
                ++perimeter;
        }

        return perimeter;
    }

    public static boolean isValidCoordinate(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length)
            return false;
        return true;
    }
}
