package com.uci.mj;

/**
 * Created by junm5 on 12/19/16.
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length < 2) {
            return nums.length;
        }

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                count++;
                while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                    i++;
                }
            } else if (nums[i-1] > nums[i]) {
                count++;
                while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                    i++;
                }
            }
        }

        return count;


//        if (nums.length < 2) {
//            return nums.length;
//        }
//        int k = 0;
//        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {  //Skips all the same numbers from series beginning eg 5, 5, 5 1
//            k++;
//        }
//        if (k == nums.length - 1) {
//            return 1;
//        }
//        int result = 2;     // This will track the result of result array
//        boolean smallReq = nums[k] < nums[k + 1];       //To check series starting pattern
//        for (int i = k + 1; i < nums.length - 1; i++) {
//            if (smallReq && nums[i + 1] < nums[i]) {
//                nums[result] = nums[i + 1];
//                result++;
//                smallReq = !smallReq;    //Toggle the requirement from small to big number
//            } else {
//                if (!smallReq && nums[i + 1] > nums[i]) {
//                    nums[result] = nums[i + 1];
//                    result++;
//                    smallReq = !smallReq;    //Toggle the requirement from big to small number
//                }
//            }
//        }
//        return result;
    }

    public static void main(String[] args) {
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int re = wiggleSubsequence.wiggleMaxLength(nums);
        System.out.println(re);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
