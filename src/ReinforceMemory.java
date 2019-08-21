import java.util.HashMap;
import java.util.NoSuchElementException;

public class ReinforceMemory {
    public static void main(String[] args) {
        char[][] map1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(numberOfIslands(map1));

        char[][] map2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numberOfIslands(map2));

    }

    public static int numberOfIslands(char[][] map) {
        // not initialized or no rows or no columns in row 0
        if (map == null || map.length == 0 || map[0].length == 0)
            return 0;

        int numIslands = 0;
        for (int r = 0; r < map.length; ++r) {
            for (int c = 0; c < map[r].length; ++c) {
                if (map[r][c] == '1')
                    numIslands += dfs(map, r, c);
            }
        }

        return numIslands;
    }

    public static int dfs(char[][] map, int r, int c) {
        // if out of bounds or water
        if ((r < 0 || r >= map.length) || (c < 0 || c >= map[r].length) || map[r][c] == '0')
            return 0;

        // sink the island
        map[r][c] = '0';

        dfs(map, r - 1, c); // check up
        dfs(map, r + 1, c); // check down
        dfs(map, r, c - 1); // check left
        dfs(map, r, c + 1); // check right

        return 1;
    }
}
