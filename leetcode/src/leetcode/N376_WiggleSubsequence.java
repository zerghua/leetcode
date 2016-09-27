package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Hua on 8/8/16.

 A sequence of numbers is called a wiggle sequence if the differences
 between successive numbers strictly alternate between positive and negative.
 The first difference (if one exists) may be either positive or negative.
 A sequence with fewer than two elements is trivially a wiggle sequence.

 For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3)
 are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences,
 the first because its first two differences are positive and the second because its last difference is zero.

 Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence,
 leaving the remaining elements in their original order.

 Examples:

 Input: [1,7,4,9,2,5]
 Output: 6
 The entire sequence is a wiggle sequence.

 Input: [1,17,5,10,13,15,10,5,16,8]
 Output: 7
 There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

 16,-12,5,3,2,-5,11,-8

 Input: [1,2,3,4,5,6,7,8,9]
 Output: 2

 Follow up:
 Can you do it in O(n) time?



 */
public class N376_WiggleSubsequence {
    //0 ms
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int p=1, q=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]) p = q+1;
            else if(nums[i] < nums[i-1]) q=p+1;
        }
        return Math.max(q,p);
    }

    public int wiggleMaxLength2(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <=1) return nums.length;
        int count=1;
        for(int j=0, i=1; i<nums.length;j=i,i++){
            if(nums[j] < nums[i]){
                count++;
                while(i<nums.length-1 && nums[i] <= nums[i+1]) i++;
            }else if(nums[j] > nums[i]){
                count++;
                while(i<nums.length-1 && nums[i] >= nums[i+1]) i++;
            }
        }
        return count;
    }


        public static void main(String[] args) {
        N376_WiggleSubsequence s = new N376_WiggleSubsequence();
        s.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8});

    }
}
