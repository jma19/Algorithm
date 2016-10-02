package com.uci.mj;

/**
 * Created by junm5 on 9/23/16.
 */
public class Rob {
    public int rob(int[] nums) {
        //dp problem
        int[] dp = new int[nums.length];

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int rob1 = rob.rob(new int[]{1, 1, 1});
        System.out.println(rob1);
    }
}
