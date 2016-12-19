package com.uci.mj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by junm5 on 11/14/16.
 */
public class SumKRecursive {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        sumHelper(res, nums, 0, target, new ArrayList<Integer>());

        return res;
    }

    void sumHelper(List<List<Integer>> res, int[] nums, int start, int target, List<Integer> temp) {

        if (temp.size() == 4) {
            int sum = 0;
            for (Integer val : temp) {
                sum += val;
            }

            if (sum == target && !res.contains(temp)) {
                res.add(new ArrayList(temp));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            sumHelper(res, nums, i + 1, target, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        SumKRecursive sum4 = new SumKRecursive();
        int[] nums = {1, 0, -1, 0, -2, 2};
        Arrays.sort(nums);
        List<List<Integer>> lists = sum4.fourSum(nums, 0);
        System.out.println("final res = " + lists);

    }
}

