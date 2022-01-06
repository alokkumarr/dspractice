package leetcode;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int noOfIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // look for island
                if (grid[i][j] == '1')
                    noOfIsland += dfs(grid, i, j);
            }
        }

        return noOfIsland;
    }

    private int dfs(char[][] grid, int i, int j) {
        // base case to check no
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return 0;

        // mark visited element '0'
        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        return 1;
    }


}
