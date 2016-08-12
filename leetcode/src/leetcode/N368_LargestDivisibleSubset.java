package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HuaZ on 8/12/2016.
 *
 Given a set of distinct positive integers,
 find the largest subset such that every pair (Si, Sj) of elements
 in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 nums: [1,2,3]

 Result: [1,2] (of course, [1,3] will also be ok)

 Example 2:

 nums: [1,2,4,8]

 Result: [1,2,4,8]



 */
public class N368_LargestDivisibleSubset {
    // 35 ms
    // DP + backtrace. Use array to backtrack index.
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) return ret;
        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length]; //to backtrace
        int maxLength = 0, maxIndex = -1;
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i-1; j>=0;j--){
                if(nums[i] % nums[j] ==0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if(dp[i] > maxLength){
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        for(int i=maxIndex; i!=-1; i=parent[i])  ret.add(nums[i]);  //backtrace
        return ret;
    }
}
