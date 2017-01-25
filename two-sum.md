Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

**Example**
~~~
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
~~~

#### Analysis & Solution

**Solution 1**: brute force, use two loops to scan all combinations, O(n^2)

**Solution 2**: Sort the array first, and then use two pointers low, high to scan the array only once, which takes O(nlogn) time. 

**Solution 3**: Use hashmap, which only requires scanning the array once. 

~~~
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap();
    for(int i = 0; i < nums.length; i++){
        if(map.containsKey(nums[i])){
            return new int[]{i, map.get(nums[i])};
        }else{
            map.put(target - nums[i], i);
        }
    }
    return new int[2];
}
~~~