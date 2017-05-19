package leetcode;

/**
 * Created by Hua on 5/15/2017.

 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 For each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.

 Example 1:

 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.

 Note:

 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.

 */
public class N494_TargetSum {
    // DFS
    // 139 / 139 test cases passed.
    // 710 ms
    // DP will need sum(nums) space
    public class Solution {
        int ret = 0;
        public int findTargetSumWays(int[] nums, int S) {
            dfs(nums, S, 0, 0);
            return ret;
        }

        public void dfs(int[] nums, int S, int start, int sum){
            if(start == nums.length){
                if(sum == S) ret++;
                return;
            }
            dfs(nums, S, start+1, sum + nums[start]);
            dfs(nums, S, start+1, sum - nums[start]);
        }
    }
}
