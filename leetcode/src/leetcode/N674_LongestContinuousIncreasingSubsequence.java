package leetcode;

/**
 * Created by HuaZ on 9/10/2017.

 Given an unsorted array of integers, find the length of longest continuous increasing subsequence.

 Example 1:

 Input: [1,3,5,4,7]
 Output: 3
 Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 Even though [1,3,5,7] is also an increasing subsequence,
 it's not a continuous one where 5 and 7 are separated by 4.

 Example 2:

 Input: [2,2,2,2,2]
 Output: 1
 Explanation: The longest continuous increasing subsequence is [2], its length is 1.

 Note: Length of the array will not exceed 10,000.

 */
public class N674_LongestContinuousIncreasingSubsequence {
    // sliding window, greedy
    // my solution
    // 36 / 36 test cases passed.
    // 6 ms
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            if(nums.length == 1) return 1;

            int ret =0, i = 0, j = 1, n = nums.length;
            while(j < n){
                if(nums[j] > nums[j-1])j++;
                else{
                    ret = Math.max(ret, j - i);
                    i = j;
                    j++;
                }
            }
            ret = Math.max(ret, j-i);
            return ret;
        }
    }
}
