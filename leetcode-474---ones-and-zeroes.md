#### 474.Ones and Zeroes
The problem can be interpreted as: What's the max number of str can we pick from strs with limitation of m "0"s and n "1"s. Thus we can define dp[i][j] stands for max number of str can we pick from strs with limitation of i "0"s and j "1"s. For each str, assume it has a "0"s and b "1"s, we update the dp array iteratively and set dp[i][j] = Math.max(dp[i][j], dp[i - a][j - b] + 1). So and the end, dp[m][n] is the answer.



~~~
   public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = count(str);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
~~~