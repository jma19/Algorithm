package amaon;

import java.util.Arrays;

/**
 * Created by junm5 on 2/21/17.
 */
public class SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1;
            //
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if (sum > target) {
                    end--;
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < target) {
                    start++;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                } else {
                    return sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SumClosest sumClosest = new SumClosest();
        int i = sumClosest.threeSumClosest(new int[]{1, 1, 1, 0}, 100);
        System.out.println(i);
    }
}
