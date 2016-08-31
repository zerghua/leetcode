package leetcode;
/*

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Hint:

    Try two pointers.
    Did you use the property of "the order of elements can be changed"?
    What happens when the elements to remove are rare?

 comments add on 8/31/2016
 */



// very similar to N26_RemoveDuplicatesfromSortedArray
// two pointers. one points to the to-be inserted position and moves when condition meets, another one goes on.
public class N27_RemoveElement {
	
	//276 ms 76%
    public int removeElement(int[] nums, int val) {
    	int count=0;
    	for(int i=0;i<nums.length;i++)
    		if(nums[i] ==val) count++;

        int l=0,r=nums.length-1;
    	while(l < r){
    		if(nums[l] == val) {
    			while(nums[r] == val && r>0) r--;

    			nums[l] = nums[r];
    			r--;
    		}
    		l++;
    	}
    	return nums.length - count;
    }
    
    //268 ms  85%
    public int removeElement2(int[] nums, int val) {
        int i=0, j=0;
        while(j < nums.length){
            if(nums[j] != val){
            	nums[i] = nums[j];
                i++; 
            }
            j++;
        }
        return i;
    }    
    
    //288 ms  58%
    public int removeElement3(int[] nums, int val) {
        int l=0,r=nums.length-1;
    	while(l <= r){
    		if(nums[l] == val) {
    			nums[l] = nums[r];
    			r--;
    			continue;
    		}
    		l++;
    	}
    	return r+1;
    }
}
