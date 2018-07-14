package Applovin;

/**
 * Created by junm5 on 7/5/18.
 */
public class MiniumMov {
    public static void main(String[] args){
        MiniumMov miniumMov = new MiniumMov();
        int[] nums ={2, 3, 1};

        System.out.println(miniumMov.minMoves2(nums));
    }
    public int minMoves2(int[] nums) {
        int k = nums.length/2;
        int median = quickselect(nums, k, 0, nums.length - 1);

        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += Math.abs(nums[i] - median);
        }
        return ans;
    }
    private int partion(int[] nums, int left, int right){
        int pivot = nums[left];
        int i = left;
        while(i <= right){
            if(nums[right] <

                    pivot){
                i++;
                swap(nums, i, right);
            }
            right--;
        }
        swap(nums, i, left);
        return i;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private int quickselect(int[] nums, int k, int left, int right){
        if(left <= right){
            int index = partion(nums, left, right);
            if(index == k){
                return nums[index];
            }
            return index > k ?
                    quickselect(nums, k, left, index - 1):
                    quickselect(nums, k, index + 1, right);
        }
        return -1;
    }
}
