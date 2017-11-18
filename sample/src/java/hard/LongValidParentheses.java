package hard;

import java.util.*;

/**
 * Created by junm5 on 9/26/17.
 */
public class LongValidParentheses {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) >= 2) {
                    count++;
                }
            } else {
                if (map.get(key + k) != null) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LongValidParentheses longValidParentheses = new LongValidParentheses();
        int pairs = longValidParentheses.findPairs(new int[]{1, 2, 3, 4, 5}, -1);
        System.out.println(pairs);

    }

}
