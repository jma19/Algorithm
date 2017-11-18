package hard;

import java.util.*;

/**
 * Created by junm5 on 11/13/17.
 */
public class ContinusSubArraySum {


//    public boolean checkSubarraySum(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
//        int runningSum = 0;
//        for (int i=0;i<nums.length;i++) {
//            runningSum += nums[i];
//            if (k != 0) runningSum %= k;
//            Integer prev = map.get(runningSum);
//            if (prev != null) {
//                if (i - prev > 1) return true;
//            }
//            else map.put(runningSum, i);
//        }
//        return false;
//    }

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < coins.length; i++) {
            queue.offer(amount - coins[i]);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                Integer val = queue.poll();
                if (val == 0) {
                    return cnt;
                }
                for (int j = 0; j < coins.length; j++) {
                    if(val - coins[j] >= 0){
                        queue.offer(val - coins[j]);
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        ContinusSubArraySum continusSubArraySum = new ContinusSubArraySum();
        //continusSubArraySum.checkSubarraySum(new int[]{6}, 6);

        int i = continusSubArraySum.coinChange(new int[]{1, 2, 5}, 10);
        System.out.println(i);
    }
}
