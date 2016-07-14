package leetcode;

import java.util.ArrayList;

/**
 * Created by Hua on 5/28/2016.

 Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 Note that there may be more than one LIS combination, it is only necessary for you
 to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?

 */
public class N300_LongestIncreasingSubsequence {
    //33 ms
    // DP, o(n^2), inner loop [0,i-1]
    // important, make a note on how inner loop works in this case.
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        if(nums == null || nums.length==0) return 0;

        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    // 3 ms o(nlogn), binary search and replace
    // replace the element in the list which is the smallest but bigger than num
    // will guarantee the size of list but not real list.
    public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length==0) return 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int n: nums){
            if(list.isEmpty()) list.add(n);
            else if(n > list.get(list.size()-1)) list.add(n);
            else{
                int left=0, right=list.size()-1;
                while(left<right){
                    int mid = (right-left)/2 + left;
                    if(list.get(mid) < n) left=mid+1;
                    else right = mid;
                }
                list.set(right, n);
            }
        }
        return list.size();
    }
}
