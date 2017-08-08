package leetcode;

/**
 * Created by HuaZ on 8/17/2016.

 Given an integer array with all positive numbers and no duplicates,
 find the number of possible combinations that add up to a positive integer target.

 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.

 Follow up:
 What if negative numbers are allowed in the given array?
 How does it change the problem?
 What limitation we need to add to the question to allow negative numbers?

corner case:
 1.  [9]    3     return 0
 2.  [1,9]  3     return 1

Performance/Memory follow up:
 1. [1000000, 20000000, 3000000]   80000000


 */
public class N377_CombinationSum {
    // Google, Facebook
    // 6 ms  DP  o(n)
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        for(int n: nums) if(n<= target) dp[n] = 1;
        for(int i=0;i<=target;i++){
            for(int n: nums){
                if(n+i<=target) dp[n+i] += dp[i];
            }
        }
        return dp[target];
    }

    // 7 ms
    public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;  //base case
        for(int i=1;i<=target;i++){
            for(int n: nums){
                dp[i] += i - n >=0? dp[i-n] : 0;
            }
        }
        return dp[target];
    }
}
