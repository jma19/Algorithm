package google;

/**
 * Created by junm5 on 4/1/17.
 */
public class SingleEleInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        // binary search
        int n = nums.length, lo = 0, hi = n / 2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2 * m] != nums[2 * m + 1]) hi = m;
            else lo = m + 1;
        }
        return nums[2 * lo];
    }

    public static void main(String[] args) {
        SingleEleInSortedArray singleEleInSortedArray = new SingleEleInSortedArray();
        int i = singleEleInSortedArray.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 8, 8});
    }

}
