package com.uci.mj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by junm5 on 11/3/16.
 */
public class SubsetII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }

        res.add(new ArrayList<Integer>());
        helper(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }

    void helper(List<List<Integer>> res, int[] nums, List<Integer> temp, Integer start) {
        if (!res.contains(temp)) {
            res.add(new ArrayList(temp));
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(res, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
////        SubsetII subsetII = new SubsetII();
////        List<List<Integer>> lists = subsetII.subsetsWithDup(new int[]{4,1,0});
////        for(List list : lists){
////            System.out.println(list);
//        }
        Random random = new Random();
        for(int a = 0 ; a <10; a++){
            int i = random.nextInt(3);
            System.out.println(i);
        }
    }
}
