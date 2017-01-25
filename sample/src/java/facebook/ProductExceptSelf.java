package facebook;

/**
 * Created by junm5 on 1/6/17.
 */
public class ProductExceptSelf {
    public int[] ProductExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
    public static void main(String[] args ){
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        productExceptSelf.ProductExceptSelf(new int[]{1,2,3,4});

    }

}
