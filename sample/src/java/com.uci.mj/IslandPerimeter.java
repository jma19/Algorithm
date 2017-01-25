package com.uci.mj;

/**
 * Created by junm5 on 12/13/16.
 */
public class IslandPerimeter {

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int res = islandPerimeter.islandPerimeter(new int[][]{
                {0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}
        });
        System.out.println(res);
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] res = new int[1];
        //dfs not necessary
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //find the first land block
                if (grid[i][j] == 1) {
                    dfs(grid, res, i, j);
                    return res[0];
                }
            }
        }
        return 0;
    }

    int[][] ops = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    void dfs(int[][] grid, int[] res, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        }
        //represented has visited
        grid[i][j] = 2;

        //check upper
        if (i - 1 < 0 || grid[i - 1][j] == 0) {
            res[0]++;
        }
        //check left
        if (j - 1 < 0 || grid[i][j - 1] == 0) {
            res[0]++;
        }
        //check lower
        if (i + 1 >= grid.length || grid[i + 1][j] == 0) {
            res[0]++;
        }
        //check right
        if (j + 1 >= grid[0].length || grid[i][j + 1] == 0) {
            res[0]++;
        }
        for (int k = 0; k < ops.length; k++) {
            dfs(grid, res, i + ops[k][0], j + ops[k][1]);
        }
    }
}
