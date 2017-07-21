package leetcode;

/**
 * Created by Hua on 7/21/2017.

 Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:

 0 < i, i + 1 < j, j + 1 < k < n - 1
 Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.

 where we define that subarray (L, R) represents a slice of the original array
 starting from the element indexed L to the element indexed R.

 Example:

 Input: [1,2,1,2,1,2,1]
 Output: True
 Explanation:
 i = 1, j = 3, k = 5.
 sum(0, i - 1) = sum(0, 0) = 1
 sum(i + 1, j - 1) = sum(2, 2) = 1
 sum(j + 1, k - 1) = sum(4, 4) = 1
 sum(k + 1, n - 1) = sum(6, 6) = 1

 Note:

 1 <= n <= 2000.
 Elements in the given array will be in range [-1,000,000, 1,000,000].



 */

import java.util.*;
public class N548_SplitArraywithEqualSum {
    // divide and conquer, find 1 and 4 segments are equal and then compare if 2 and 3 are equal to them.
    // 120 / 120 test cases passed.
    // 25 ms
    public class Solution {
        public boolean splitArray(int[] nums) {
            if(nums == null || nums.length < 7) return false;
            HashMap<Integer, List<Integer>> map = new HashMap();
            int sum = 0;
            // add sum 4th segment into hashmap
            for(int i= nums.length -1; i>5; i--){
                sum += nums[i];
                if(!map.containsKey(sum)) map.put(sum, new ArrayList());
                map.get(sum).add(i);
            }

            sum = 0;
            for(int i=0; i< nums.length - 6; i++){
                sum += nums[i];
                if(map.containsKey(sum)){
                    for(int j : map.get(sum)){
                        if(foundEqual(nums, i+2, j-2, sum)) return true;
                    }
                }
            }
            return false;
        }

        public boolean foundEqual(int[] nums, int lo, int hi, int target){
            int sum = 0;
            for(int i=lo; i<=hi; i++) sum += nums[i];

            int cur = 0;
            for(int i=lo; i<hi-1; i++){
                cur += nums[i];
                if(cur == target && sum - cur - nums[i+1] == target) return true;
            }
            return false;
        }
    }


    // another concise solution
    // Here j is used for middle cut, i for left cut and k for right cut.
    // Iterate middle cuts and then find left cuts which divides the first half into two equal quarters,
    // store that quarter sums in the hashset. Then find right cuts which divides the second half into two equal
    // quarters and check if quarter sum is present in the hashset. If yes return true.
    // 120 / 120 test cases passed.
    // 160 ms
    public class Solution2 {
        public boolean splitArray(int[] nums) {
            if (nums.length < 7)
                return false;
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
            for (int j = 3; j < nums.length - 3; j++) {
                HashSet < Integer > set = new HashSet < > ();
                for (int i = 1; i < j - 1; i++) {
                    if (sum[i - 1] == sum[j - 1] - sum[i])
                        set.add(sum[i - 1]);
                }
                for (int k = j + 2; k < nums.length - 1; k++) {
                    if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[j] && set.contains(sum[k - 1] - sum[j])) //I think here might be a bug
                        return true;
                }
            }
            return false;
        }
    }
}
