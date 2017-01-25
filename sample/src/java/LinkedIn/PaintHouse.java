package LinkedIn;

/**
 * Created by junm5 on 12/26/16.
 */
public class PaintHouse {
    /**
     * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
     * The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
     * <p>
     * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
     * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
     * Find the minimum cost to paint all houses.
     */
    public int minCost(int[][] costs) {
        int m = costs.length, n = costs[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }

        return res;
    }
}
