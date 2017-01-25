package com.uci.mj;

/**
 * Created by junm5 on 12/26/16.
 */
public class TotalHanmingDistance {

    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length, numOfBitOne = 0;

        for(int i = 0; i < 32; i++){
            numOfBitOne = 0;
            for(int j = 0; j < nums.length; j++){
                if(((nums[j] >> i) & 1) == 1){
                    numOfBitOne++;
                }
            }
            total += numOfBitOne * (n - numOfBitOne);
        }
        return total;
    }
}
