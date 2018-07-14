package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

class CountSmllerThanItSelf {
    //calculate from the last element, and 
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(nums[i], temp);
            res.add(index);
            temp.add(index, nums[i]);
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * find a the right index that has greater value in sorted nums than val
     */
    private int findIndex(int val, List<Integer> nums) {
        int low = 0, high = nums.size();
        while (low < high) {
            int middle = (low + high) / 2;
            if (nums.get(middle) < val) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        CountSmllerThanItSelf solution = new CountSmllerThanItSelf();
        UUID uuid = UUID.randomUUID();

        List<Integer> integers = solution.countSmaller(new int[]{5, 2, 6, 1});
        System.out.println(integers);
    }

}