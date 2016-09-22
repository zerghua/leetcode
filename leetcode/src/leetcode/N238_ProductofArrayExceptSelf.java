package leetcode;
/*
 Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

 */
public class N238_ProductofArrayExceptSelf {
	//2 ms
    public int[] productExceptSelf(int[] nums) {
    	if(nums == null || nums.length==0) return null;
    	int[] ret = new int[nums.length];
    	ret[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--){
        	ret[i] = nums[i+1] * ret[i+1];
        }
        
    	int left_sum=nums[0];
    	for(int i=1; i<nums.length; i++){
    		ret[i] *= left_sum;
    		left_sum *= nums[i];
    	}
    	return ret;
    }
}
