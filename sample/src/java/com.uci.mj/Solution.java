package com.uci.mj;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int[] diff = new int[nums.length];
        for(int i = 1; i < nums.length; i++){
            diff[i] = nums[i] - nums[i-1];
        }
        dp[0] = 1;
        if(diff[1] == 0){
            dp[1] =1;
        }else{
            dp[1] = 2;
        }
        int max = dp[1];
        for(int i = 2; i<nums.length; i++){
            if(diff[i] * diff[i-1] < 0){
                dp[i] = dp[i-1] + 1;
            }
            else if(diff[i] * diff[i-1] == 0){
                dp[i] = 1;
            }
            else{
                dp[i] = 2;
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
    public static void main(String[] arsg){
        Solution solution = new Solution();
        solution.wiggleMaxLength(new int[]{0,0});
    }
}