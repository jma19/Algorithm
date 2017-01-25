package facebook;

/**
 * Created by junm5 on 1/7/17.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //using dp to solve this problem, the worst case is O(n^2)
        int dp[] = new int[nums.length];
        //dp[i] stands for the longest Increasing subsequence end with nums[i]
        int max = 1;
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            int tempMax = 1;
            for(int j = i-1; j >=0; j--){
                if(nums[j] < nums[i]){
                    tempMax = Math.max(dp[j] + 1, tempMax);
                }
            }
            dp[i] = tempMax;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
