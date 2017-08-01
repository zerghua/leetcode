package leetcode;

/**
 * Created by Hua on 8/1/2017.

 You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

 Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c.
 Chain of pairs can be formed in this fashion.

 Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs.
 You can select pairs in any order.

 Example 1:

 Input: [[1,2], [2,3], [3,4]]
 Output: 2
 Explanation: The longest chain is [1,2] -> [3,4]

 Note:

 The number of given pairs will be in the range [1, 1000].

 */

import java.util.*;
public class N646_MaximumLengthofPairChain {
    // Amazon
    // sort + DP  time o(n^2)
    // 202 / 202 test cases passed.
    // 229 ms
    public class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a,b) -> a[0] - b[0]);  //sort by first of the pair
            int n = pairs.length;
            int[] dp = new int[n+1];
            Arrays.fill(dp, 1);
            for(int i=2;i<=n;i++){
                for(int j=1; j<i; j++){
                    if(pairs[i-1][0] > pairs[j-1][1]) dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            return dp[n];
        }
    }

    // sort + greedy  time o(nlogn)
    // 202 / 202 test cases passed.
    // 110 ms
    public class Solution2 {
        public int findLongestChain(int[][] pairs) {
            if(pairs == null || pairs.length ==0 ) return 0;
            Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));

            int ret=1, end = pairs[0][1];
            for(int i =1; i<pairs.length; i++) {
                if(pairs[i][0]>end){
                    ret++;
                    end = pairs[i][1];
                }
            }
            return ret;
        }
    }
}
