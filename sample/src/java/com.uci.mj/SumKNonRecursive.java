package com.uci.mj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by junm5 on 11/14/16.
 */
public class SumKNonRecursive {
    private List<List<Integer>> nSum(int[] nums, int start, int n, int target) {
        List<List<Integer>> result = new LinkedList();
        // target is too small or too large so that there won't be solutions.
        if (target < nums[start] * n || target > nums[nums.length - 1] * n) {
            return result;
        }

        for (int i = start; i <= nums.length - n; ++i) {
            // avoid duplicated solutions
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            if (n == 1) {
                // binary search can be used here to improve performance
                if (target > nums[i]) {
                    continue;
                }
                if (target < nums[i]) {
                    break;
                }
                result.add(new LinkedList<Integer>(Arrays.asList(target)));
                break;
            }

            for (List<Integer> list : nSum(nums, i + 1, n - 1, target - nums[i])) {
                list.add(nums[i]);
                result.add(list);
            }

        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0) {
            return Arrays.asList();
        }
        Arrays.sort(nums);
        return nSum(nums, 0, 4, target);
    }
}
