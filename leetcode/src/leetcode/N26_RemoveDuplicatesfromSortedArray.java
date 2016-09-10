package leetcode;
/*

 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length.

 */
public class N26_RemoveDuplicatesfromSortedArray {
	
	// 1 ms
    // two pointers, condition on if they are not equal.
    public int removeDuplicates(int[] nums) {
    	if(nums.length ==0) return 0;
    	
        int i=0,j=0;
        while(j<nums.length){
        	if(nums[i] != nums[j]){
        		i++;
        		nums[i] = nums[j];
        	}
        	j++;
        }
        return i+1;
    }

	// version 2 added on 9/10/2016
	// 2 ms  161 / 161 test cases passed.
	// two pointers, i as the end of array, continue if it's equal(skipped)
    // assign next of it(nums[++i]) when it's not equal
	public class Solution {
		public int removeDuplicates(int[] nums) {
			if(nums.length ==0) return 0;
			int i=0;
			for(int n: nums){
				if(n != nums[i]) nums[++i] = n;
			}
			return i+1;
		}
	}
}
