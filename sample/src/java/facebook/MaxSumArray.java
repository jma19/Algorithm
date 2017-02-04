package facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by junm5 on 1/1/17.
 */
public class MaxSumArray {
    public int maxSubArrayLen(int[] nums, int k) {
        //this sum[j] - sum[i] == k
        //can be transform into two-sum problem
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            nums[i] += nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i] - k)) {
                max = Math.max(max, i - map.get(nums[i] - k));
            } else {
                map.put(nums[i], i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSumArray maxSumArray = new MaxSumArray();
        maxSumArray.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3);
        Integer.highestOneBit(1)
    }
}
