package leetcode;

/**
 * Created by HuaZ on 8/26/2017.

 Given an array with n integers, your task is to check if it could become non-decreasing
 by modifying at most 1 element.

 We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

 Example 1:

 Input: [4,2,3]
 Output: True
 Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

 Example 2:

 Input: [4,2,1]
 Output: False
 Explanation: You can't get a non-decreasing array by modify at most one element.

 Note: The n belongs to [1, 10,000].

test cases:
 // [3,4,2,3]  false
 // [4,2,1]    false
 // [2,3,3,2,4]  true
 // [4,2,3]    true
 */
public class N665_NondecreasingArray {
    // 2 ways to fix, increase nums[i+1]  or decrease nums[i] when nums[i] > nums[i+1]
    // 325 / 325 test cases passed.
    // 21 ms
    class Solution {
        public boolean checkPossibility(int[] nums) {
            int count = 0;
            for(int i=0; i<nums.length-1;i++){
                if(nums[i] > nums[i+1]){
                    count++;
                    if(i>0 && nums[i+1] < nums[i-1]) nums[i+1] = nums[i]; // increase nums[i+1]
                    else nums[i] = nums[i+1];                             // decrease nums[i]
                }
            }
            return count <= 1;
        }
    }
}
