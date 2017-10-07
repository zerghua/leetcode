package leetcode;

/**
 * Created by HuaZ on 10/7/2017.

 In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

 Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

 Return the result as a list of indices representing the starting position of each interval (0-indexed).
 If there are multiple answers, return the lexicographically smallest one.

 Example:

 Input: [1,2,1,2,6,7,5,1], 2
 Output: [0, 3, 5]
 Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.

 Note:
 nums.length will be between 1 and 20000.
 nums[i] will be between 1 and 65535.
 k will be between 1 and floor(nums.length / 3).

 */
public class N689_MaximumSumof3NonOverlappingSubarrays {
    // DP 1D * 3; window_k_sum[], left_sum[], right_sum[]
    // quite hard to solve it
    // others solution
    // 37 / 37 test cases passed.
    // 9 ms
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
            //window is an array of sums of windows size k
            int[] window = new int[nums.length - K + 1];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (i >= K) sum -= nums[i-K];
                if (i >= K-1) window[i-K+1] = sum;
            }

            int[] left = new int[window.length];
            int best = 0;
            for (int i = 0; i < window.length; i++) {
                if (window[i] > window[best]) best = i;
                left[i] = best;
            }

            int[] right = new int[window.length];
            best = window.length - 1;
            for (int i = window.length - 1; i >= 0; i--) {
                if (window[i] >= window[best]) best = i;
                right[i] = best;
            }

            int[] ans = new int[]{-1, -1, -1};
            for (int j = K; j < window.length - K; j++) {
                int i = left[j - K], k = right[j + K];
                if (ans[0] == -1 || window[i] + window[j] + window[k] >
                        window[ans[0]] + window[ans[1]] + window[ans[2]]) {

                    ans[0] = i;
                    ans[1] = j;
                    ans[2] = k;
                }
            }
            return ans;
        }
    }
}
