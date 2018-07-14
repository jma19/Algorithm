package google;

/**
 * Created by junm5 on 5/5/18.
 */
public class RemoveDuplicate {

    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int count = 1;
        int start = 1, end = 2;

        if(nums[start] == nums[start - 1]){
            count++;
        }
        for(; end < nums.length; end++){
            if(nums[end] != nums[start]){
                start++;
                count = 1;
                sw(nums, start, end);
            }else{
                if(count == 1){
                    start++;
                    sw(nums, start, end);
                }
            }
        }

        return start + 1;
    }
    void sw(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args){
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        removeDuplicate.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});

    }
}
