package amaon;

/**
 * Created by junm5 on 1/26/17.
 */
public class ThreeSum {
    /**
     * // Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
     * Return the sum of the three integers. You may assume that each input would have exactly one solution
     */
    public int findCircleNum(int[][] M) {
        //find the all 1's block
        boolean[][] visited = new boolean[M.length][M[0].length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (!visited[i][j] && M[i][j] == 1) {
                    count++;
                    DFS(M, visited, i, j);
                }
            }
        }
        return count;
    }

    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void DFS(int[][] M, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= M.length ||
                j < 0 || j >= M[0].length || visited[i][j] || M[i][j] == 1) {
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < dir.length; k++) {
            DFS(M, visited, i + dir[k][0], j + dir[k][1]);
        }
    }


}
