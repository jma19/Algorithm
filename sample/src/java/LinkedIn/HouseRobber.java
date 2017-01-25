package LinkedIn;

import java.util.*;

/**
 * Created by junm5 on 12/28/16.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        //dp[i] stands for
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        houseRobber.rob(new int[]{1, 1, 2, 1});
        Collections.sort(new ArrayList<Comparable>(), new Comparator<Comparable>() {
            public int compare(Comparable o1, Comparable o2) {
                return -1;
            }

        });
    }
}
