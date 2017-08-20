package leetcode;

/**
 * Created by Hua on 3/21/2016.

 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.

 */
public class N80_RemoveDuplicatesfromSortedArray2 {
    // Facebook
    // version 3 added on 9/10/2016
    // 1 ms  164 / 164 test cases passed.
    // similar to 26, rather than compare with i, this time compares with i-1.
    // if equal, continue to skip it, else num[++i] = nums[j]
    public class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length <3) return nums.length;
            int i=1;
            for(int j=2;j<nums.length;j++){
                if(nums[i-1] != nums[j]) nums[++i] = nums[j];
            }
            return i+1;
        }
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length ==0) return 0;

        int i=0;
        int allowed_duplicate_times=1;
        int current_duplicate_times=0;
        for(int j=1; j< nums.length ; j++){
            if(nums[i] == nums[j] && current_duplicate_times < allowed_duplicate_times){
                i++;
                nums[i] = nums[j];
                current_duplicate_times++;
            }
            else if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
                current_duplicate_times=0;
            }
        }
        return i+1;
    }


    public int removeDuplicates2(int[] nums) {
        if(nums.length <3) return nums.length;

        int end=1;
        for(int i=2;i<nums.length;i++){
            if(nums[i] != nums[end-1]){
                end++;
                nums[end] = nums[i];
            }
        }
        return end+1;
    }

}
