package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 1/1/17.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int len = nums.length;
        int n = 1 << len;

        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList();
            int count = 0;
            while (count < len) {
                if ((i & (1 << count)) == 1) {
                    temp.add(nums[count]);
                }
                count++;
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(new int[]{1, 2, 3});
        String a = "ajac";
        System.out.println(a.lastIndexOf("\t"));
    }
}
