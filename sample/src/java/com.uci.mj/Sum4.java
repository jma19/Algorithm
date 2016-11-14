package com.uci.mj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 11/14/16.
 */
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        return null;
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
        for (int i = start; i < nums.length - 3; i++) {
            temp.add(nums[start]);
            sumHelper(res, nums, start + 1, target, temp);
            temp.remove();
        }
    }
    public static void main(String [] args){

    }
}

