package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 1/14/17.
 */
public class FindAllDispearNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for( int i=0;i< nums.length; i++){
            int index = nums[i];
            if(nums[Math.abs(index)-1] > 0){
                nums[Math.abs(index)-1]= -nums[Math.abs(index)-1];
            }
        }

        for(int j =1 ;j <= nums.length ; j++){
            if(nums[j-1] > 0){
                result.add(j);
            }
        }
        return result;
    }
    public static void main(String[] args){
        FindAllDispearNumber findAllDispearNumber = new FindAllDispearNumber();
        findAllDispearNumber.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});

        String str = " 12343";
        //non repeated and non character

    }
}
