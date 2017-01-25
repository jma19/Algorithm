package com.uci.mj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by junm5 on 12/23/16.
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums == null || nums.length ==0){
            return res;
        }
        int visited[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            visited[0] =0;
        }
        Arrays.sort(nums);
        backtracking(res, new ArrayList(), nums, visited);
        return res;
    }

    void backtracking(List<List<Integer>> res, List<Integer> temp, int[] nums, int[] visited){
        if(temp.size() == nums.length){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i -1] && visited[i-1] == 0|| visited[i] == 1){
                continue;
            }
            visited[i]  = 1;
            temp.add(nums[i]);
            backtracking(res, temp, nums, visited);
            temp.remove(temp.size()-1);
            visited[i] = 0;
        }
    }
}
