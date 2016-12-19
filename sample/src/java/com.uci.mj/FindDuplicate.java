package com.uci.mj;

/**
 * Created by junm5 on 11/2/16.
 */
public class FindDuplicate {
    //BS
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            int c = 0;

            for (int i : nums) {
                if (i <= m) {
                    c++;
                }
            }

            //if c < m,
            if (c > m) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return r;
    }

    public static void main(String[]args){
//        FindDuplicate findDuplicate = new FindDuplicate();
//        findDuplicate.findDuplicate(new int[]{1,2,2});

        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.deleteCharAt(stringBuffer.length()-1);

    }
}
