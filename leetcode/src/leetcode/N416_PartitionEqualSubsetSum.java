package leetcode;

/**
 * Created by HuaZ on 10/17/2016.

 Given a non-empty array containing only positive integers,
 find if the array can be partitioned into two subsets such that
 the sum of elements in both subsets is equal.

 Note:

 Each of the array element will not exceed 100.
 The array size will not exceed 200.

 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].

 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.


 */
public class N416_PartitionEqualSubsetSum {
    // DP, locate target by sum/2;  o(n^2) time,  o(n) space.
    // 40 ms  115 / 115 test cases passed.
    public class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int e: nums) sum+= e;
            if((sum &1) == 1) return false;  //odd sum return false
            int target = sum/2; // key part here, if we find numbers added to half of sum, means a go.
            boolean[] dp = new boolean[target+1];
            dp[0] = true;
            for(int e: nums){
                for(int i=target;i>=0;i--){ //has to be [target,0] or using same int multiple times, wrong.
                    if(dp[i] && i+e <= target){
                        dp[i+e] = true;
                    }
                }
            }
            return dp[target];
        }
    }

    // with one pruning from above solution.
    // 22 ms  115 / 115 test cases passed.
    public class Solution2 {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int e: nums) sum+= e;
            if((sum &1) == 1) return false;  //odd sum return false
            int target = sum/2; // key part here, if we find numbers added to half of sum, means a go.
            boolean[] dp = new boolean[target+1];
            dp[0] = true;
            for(int e: nums){
                for(int i=target;i>=0;i--){ //has to be [target,0] or using same int multiple times, wrong.
                    if(dp[i] && i+e <= target){
                        dp[i+e] = true;
                    }
                }
                if(dp[target]) return true;  //pruning
            }
            return dp[target];
        }
    }
}
