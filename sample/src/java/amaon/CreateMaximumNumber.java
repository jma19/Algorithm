package amaon;

/**
 * Created by junm5 on 3/14/17.
 */
public class CreateMaximumNumber {
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
        int[] nums = {2, 3, 4, 5, 6};
        int[] ints = createMaximumNumber.maxArray(nums, 2);
        for(int i : ints){
            System.out.print(i);
        }
    }
}
