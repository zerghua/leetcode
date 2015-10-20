package leetcode;

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
