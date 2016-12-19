package com.uci.mj;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by junm5 on 11/4/16.
 */
public class ShuffeArray {
    int[] nums;
    Random random = null;

    public ShuffeArray(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] res = new int[nums.length];
        Set<Integer> indexs = new HashSet();
        int count = 0;
        while (count < nums.length) {
            int index = random.nextInt(nums.length);
            if (!indexs.contains(index)) {
                res[count] = nums[index];
                count++;
                indexs.add(index);
            }
        }
        return res;
    }

}
