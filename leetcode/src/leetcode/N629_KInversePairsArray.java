package leetcode;

/**
 * Created by Hua on 6/29/2017.

 Given two integers n and k, find how many different arrays consist of numbers from 1 to n such that
 there are exactly k inverse pairs.

 We define an inverse pair as following: For ith and jth element in the array, if i < j and a[i] > a[j]
 then it's an inverse pair; Otherwise, it's not.

 Since the answer may very large, the answer should be modulo 10^9 + 7.

 Example 1:

 Input: n = 3, k = 0
 Output: 1
 Explanation:
 Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pair.

 Example 2:

 Input: n = 3, k = 1
 Output: 2
 Explanation:
 The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.

 Note:

 The integer n is in the range [1, 1000] and k is in the range [0, 1000].



 dp[n][k] denotes the number of arrays that have k inverse pairs for array composed of 1 to n
 we can establish the recursive relationship between dp[n][k] and dp[n-1][i]:

 if we put n as the last number then all the k inverse pair should come from the first n-1 numbers
 if we put n as the second last number then there's 1 inverse pair involves n so the rest k-1 comes from the first n-1 numbers
 ...
 if we put n as the first number then there's n-1 inverse pairs involve n so the rest k-(n-1) comes from the first n-1 numbers

 dp[n][k] = dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]

 It's possible that some where in the right hand side the second array index become negative, since we cannot generate
 negative inverse pairs we just treat them as 0, but still leave the item there as a place holder.

 dp[n][k] = dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]
 dp[n][k+1] = dp[n-1][k+1]+dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]

 so by deducting the first line from the second line, we have

 dp[n][k+1] = dp[n][k]+dp[n-1][k+1]-dp[n-1][k+1-n]
 


 */
public class N629_KInversePairsArray {
    // Works Applications
    // DP, not sure why
    // 80 / 80 test cases passed.
    // 30 ms
    public class Solution {
        public int kInversePairs(int n, int k) {
            int mod = (int)Math.pow(10, 9) + 7;
            int[] dp = new int[k+1];
            dp[0] = 1;
            for(int i=2; i<=n; i++){
                for(int j=1; j<=k; j++) dp[j] = (dp[j] + dp[j-1]) % mod;
                for(int j=k; j>=i; j--) dp[j] = (dp[j] - dp[j-i] + mod) % mod;
            }
            return dp[k];
        }
    }
}
