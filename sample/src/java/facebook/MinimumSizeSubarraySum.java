package facebook;

import java.util.TreeMap;

/**
 * Created by junm5 on 1/1/17.
 */
public class MinimumSizeSubarraySum {

    // use TreeMap, which takes O(nlogn) time
    public int minSubArrayLen(int s, int[] nums) {
        //min(j - i), sbt sum[j] - sum[i] >= s,
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        int min = n;
        treeMap.put(0, -1);
        for (int i = 0; i < n; i++) {
            Integer key = (Integer) treeMap.floorKey(nums[i] - s);
            if (key != null) {
                min = Math.min(min, i - treeMap.get(key));
            }
            treeMap.put(nums[i], i);
        }
        return min;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        //min(j - i), sbt sum[j] - sum[i] >= s,
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if(sum >= s){
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return min;
    }


}
