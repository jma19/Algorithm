#### 474.Ones and Zeroes
In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.


Example

~~~
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”

Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

~~~

#### Analysis & Solution

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