package amaon;

/**
 * Created by junm5 on 2/4/17.
 */
public class FindDuplex {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 5, 6, 7, 4};
        int low = 1, high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2, count = 0;
            for (int val : nums) {
                if (val <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
    }
}
