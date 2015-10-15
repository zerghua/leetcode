package leetcode;

public class N189_RotateArray {
	public void reverse_array(int nums[], int start, int end){
		while(start < end){
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;end--;
		}
	}
	
	//1 ms
    public void rotate(int[] nums, int k) {
    	k = k%nums.length; //corner case
    	reverse_array(nums, 0, nums.length -k - 1);
    	reverse_array(nums, nums.length -k, nums.length-1);
    	reverse_array(nums, 0, nums.length-1);
    }
}
