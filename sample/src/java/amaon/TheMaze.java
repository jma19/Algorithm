package amaon;

import java.util.HashSet;

/**
 * Created by junm5 on 4/23/17.
 */
public class TheMaze {
    public boolean hasPath(int[][] maze, int i, int j, int m, int n) {
        if (maze[i][j] == 1 || maze[m][n] == 1) {
            return false;
        }
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        return DFS(maze, isVisited, i, j, m, n);

    }

    private int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean DFS(int[][] maze, boolean[][] isVisited, int curX, int curY, int m, int n) {
        if (curX < 0 || curY >= maze[0].length || isVisited[curX][curY] || maze[curX][curY] == 1) {
            return false;
        }
        if (curX == m && curY == n) {
            return true;
        }
        isVisited[curX][curY] = true;
        boolean flag = false;

        for (int k = 0; k < dir.length; k++) {
            curX += dir[k][0];
            curY += dir[k][1];
            flag = flag || DFS(maze, isVisited, curX, curY, m, n);
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
