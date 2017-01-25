package com.uci.mj;

/**
 * Created by junm5 on 12/20/16.
 */
public class MatchsticksSquare {

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 4 != 0)
            return false;
        return dfs(nums, new int[4], 0, sum / 4);
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target)
                return true;
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] <= target) {
                sums[i] += nums[index];
                if (dfs(nums, sums, index + 1, target)) {
                    return true;
                }
                sums[i] -= nums[index];
            }
        }
        return false;
    }
    public static void main(String[] args){
        MatchsticksSquare matchsticksSquare = new MatchsticksSquare();

    }
}
