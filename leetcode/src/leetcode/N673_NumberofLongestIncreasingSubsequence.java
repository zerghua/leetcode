package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 9/10/2017.

 Given an unsorted array of integers, find the number of longest increasing subsequence.

 Example 1:

 Input: [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].

 Example 2:

 Input: [2,2,2,2,2]
 Output: 5
 Explanation: The length of longest continuous increasing subsequence is 1,
 and there are 5 subsequences' length is 1, so output 5.

 Note: Length of the given array will be not exceed 2000 and the answer
 is guaranteed to be fit in 32-bit signed int.

 */
public class N673_NumberofLongestIncreasingSubsequence {
    // DP 1D with extra array to store count info
    // my solution
    // 223 / 223 test cases passed.
    // 41 ms
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            if(nums.length == 1) return 1;
            int n = nums.length, max = 0;
            int[] dp = new int[n];     // length of longest subsequence
            int[] count = new int[n];  // count of different longest subsequence
            Arrays.fill(dp, 1);
            Arrays.fill(count, 1);

            for(int j=1; j<n; j++){
                for(int i=j-1; i>=0; i--){      // can be both ways [0,j-1] or [j-1, 0]
                    if(nums[j] > nums[i]) {
                        if(dp[j] == 1 + dp[i]) count[j] += count[i];  // important
                        else if(dp[j] < 1 + dp[i]){
                            dp[j] = 1 + dp[i];
                            count[j] = count[i];   // important
                        }
                    }
                    max = Math.max(max, dp[j]);
                }
            }

            int ret = 0;
            for(int i=0;i<n; i++){
                //System.out.println(i + " : " + count[i]  + "  dp = " + dp[i]);
                if(dp[i] == max) ret += count[i];
            }
            return ret;
        }
    }

    // others concise solution
    // 223 / 223 test cases passed.
    // 53 ms
    class Solution2 {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length, res = 0, max_len = 0;
            int[] len = new int[n], cnt = new int[n];
            for (int i = 0; i < n; i++) {
                len[i] = cnt[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (len[i] == len[j] + 1) cnt[i] += cnt[j];
                        if (len[i] < len[j] + 1) {
                            len[i] = len[j] + 1;
                            cnt[i] = cnt[j];
                        }
                    }
                }
                if (max_len == len[i]) res += cnt[i];
                if (max_len < len[i]) {
                    max_len = len[i];
                    res = cnt[i];
                }
            }
            return res;
        }
    }
}
