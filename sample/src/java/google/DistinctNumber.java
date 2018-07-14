package google;

/**
 * Created by junm5 on 4/25/18.
 */
public class DistinctNumber {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;
        int n = s.length(), m = t.length();
        int[][] dp =  new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args){
        DistinctNumber distinctNumber = new DistinctNumber();
        int i = distinctNumber.numDistinct("abc", "abc");
        System.out.println(i);

    }
}
