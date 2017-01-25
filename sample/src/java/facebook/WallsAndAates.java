package facebook;

import java.util.Stack;

/**
 * Created by junm5 on 1/5/17.
 */
public class WallsAndAates {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    BFS(rooms, new int[]{i, j});
                }
            }
        }
    }

    int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    Stack<int[]> stack = new Stack();

    void BFS(int[][] rooms, int[] points) {
        stack.push(points);
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            for (int i = 0; i < dir.length; i++) {
                int x = top[0] + dir[i][0];
                int y = top[1] + dir[i][1];
                if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] < rooms[top[0]][top[1]] + 1) {
                    continue;
                }
                rooms[x][y] = rooms[top[0]][top[1]] + 1;
                stack.push(new int[]{x, y});
            }
        }
    }

}
