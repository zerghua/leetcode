package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/16/2017.

 Given an array of integers nums and a positive integer k, find whether it's possible
 to divide this array into k non-empty subsets whose sums are all equal.

 Example 1:

 Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 Output: True
 Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

 Note:
 1 <= k <= len(nums) <= 16.
 0 < nums[i] < 10000.

 */
public class N698_PartitiontoKEqualSumSubsets {
    // my contest solution, tuned to search backwards after contest to make it AC
    // backtracking with pruning
    // 147 / 147 test cases passed.
    // 16 ms
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for(int e : nums) sum += e;
            if(sum % k != 0 ) return false;
            int p = sum / k;
            Arrays.sort(nums);
            if(nums[nums.length - 1] > p || nums.length < k) return false;

            return dfs(nums, 0, p, new boolean[nums.length], 0, k);
        }

        public boolean dfs(int[] nums, int cur, int p, boolean[] isUsed, int count, int k){
            if(k == count) return true;
            if(cur > p) return false;

            for(int i=nums.length-1; i>=0;i--){ //pruning, search backwards to AC
                if(isUsed[i]) continue;

                isUsed[i] = true;
                if(cur + nums[i] == p){
                    if(dfs(nums, 0, p, isUsed, count + 1, k)) return true;
                }
                if(dfs(nums, cur + nums[i], p, isUsed, count, k)) return true;
                isUsed[i] = false;

            }
            return false;
        }
    }


    // others solution, better code
    // backtracking, iterate through each number in sorted array.
    // 147 / 147 test cases passed.
    // 39 ms
    class Solution2{
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for(int e : nums) sum += e;
            if(sum % k != 0 ) return false;
            int p = sum / k;
            Arrays.sort(nums);
            int[] target = new int[k];
            return dfs(nums, p, target, nums.length-1);
        }

        public boolean dfs(int[] nums, int p, int[] target, int start){
            if(start == -1) return true;
            for(int i=0; i< target.length; i++){
                if(target[i] + nums[start] <= p){
                    target[i] += nums[start];
                    if(dfs(nums, p, target, start-1)) return true;
                    target[i] -= nums[start];
                }
            }
            return false;
        }
    }
}
