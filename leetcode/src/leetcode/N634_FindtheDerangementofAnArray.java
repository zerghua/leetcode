package leetcode;

/**
 * Created by HuaZ on 7/22/2017.

 In combinatorial mathematics, a derangement is a permutation of the elements of a set,
 such that no element appears in its original position.

 There's originally an array consisting of n integers from 1 to n in ascending order,
 you need to find the number of derangement it can generate.

 Also, since the answer may be very large, you should return the output mod 10^9 + 7.

 Example 1:

 Input: 3
 Output: 2
 Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] and [3,1,2].

 Note:
 n is in the range of [1, 106].

 */
public class N634_FindtheDerangementofAnArray {
    // IXL (Premium)
    // math
    // 69 / 69 test cases passed.
    // 19 ms
    // https://en.wikipedia.org/wiki/Derangement#Counting_derangements
    public class Solution {
        public int findDerangement(int n) {
            int M = (int)Math.pow(10, 9) + 7;
            long ret = 0;
            for(int i=0; i<=n; i++){
                ret = (i*ret % M + (i%2 == 0? 1 : -1));
            }
            return (int)ret;
        }
    }

    // DP
    // formula dp[i] = (i-1) * (dp[i-1] + dp[i-2])
    // 69 / 69 test cases passed.
    // 29 ms
    public class Solution2 {
        public int findDerangement(int n) {
            if(n < 2) return 0;
            int M = (int)Math.pow(10, 9) + 7;
            long[] dp = new long[n+1];
            dp[1] = 0; dp[2] = 1;
            for(int i=3; i<=n; i++){
                dp[i] = (i-1) * (dp[i-1] + dp[i-2]) % M;
            }
            return (int)dp[n];
        }
    }

    // dp without space
    // 69 / 69 test cases passed.
    // 19 ms
    public class Solution3 {
        public int findDerangement(int n) {
            if(n < 2) return 0;
            int M = (int)Math.pow(10, 9) + 7;
            long a = 0, b = 1, c=1;
            for(int i=3; i<=n; i++){
                c = (i-1) * (a + b) % M;
                a = b;
                b = c;
            }
            return (int)c;
        }
    }
}
