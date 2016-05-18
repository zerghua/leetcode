package leetcode;

/**
 * Created by Hua on 5/18/2016.

 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:

 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class N283_MoveZeroes {
    // 1ms
    // only move non-zero to head, and refill zero once done.
    public void moveZeroes(int[] nums) {
        int zero_index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[zero_index] = nums[i];
                zero_index++;
            }
        }
        for(int i=zero_index;i<nums.length;i++) nums[i] = 0;

    }
}
