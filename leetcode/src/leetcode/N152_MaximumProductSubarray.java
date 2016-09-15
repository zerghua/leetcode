package leetcode;

/**
 * Created by Hua on 4/13/2016.

 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.

 */

    //[2,0,3, 2, -1,19,-2,-3,4,6,10,-20]
    //[3,-1,4]
    //[2,-5,-2,-4,3]
public class N152_MaximumProductSubarray {
    //4 ms
    //store cur max, and cur min and update
    // DP or greedy.
    public int maxProduct(int[] nums) {
        if(nums == null) return 0;
        int cur_max = nums[0], cur_min = nums[0], max = nums[0];
        for(int i=1; i<nums.length; i++){
            int tmp = cur_max;
            cur_max = Math.max(nums[i], Math.max(cur_max*nums[i], cur_min*nums[i]));
            cur_min = Math.min(nums[i], Math.min(tmp*nums[i], cur_min*nums[i]));
            max = Math.max(max, cur_max);
        }
        return max;
    }
}
