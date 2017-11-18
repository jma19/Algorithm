package hard;

/**
 * Created by junm5 on 9/24/17.
 */
public class UniquePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] map = new int[m][n];
        map[0][0] = 1;
        for(int i = 1; i<m;i++){
            map[i][0] = (obstacleGrid[i][0] == 1) ? 0 : map[i-1][0];
        }
        for(int j= 1;j<n;j++){
            map[0][j] = obstacleGrid[0][j] == 1 ? 0 : map[0][j-1];
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = obstacleGrid[i][j] == 1 ? 0 :(map[i-1][j]+map[i][j-1]);
            }
        }
        return map[m-1][n-1];
    }
    public static void main(String [] args) {
        UniquePath uniquePath = new UniquePath();
        uniquePath.uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 0}});
    }
}
