package leetcode;

import java.util.HashMap;

/**
 * Created by Hua on 5/2/2017.

 Given an array of integers and an integer k, you need to find the total number of continuous subarrays
 whose sum equals to k.

 Example 1:

 Input:nums = [1,1,1], k = 2
 Output: 2

 Note:

 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


 */
public class N560_SubarraySumEqualsK {
    // hash table to store range. Kind of DP.
    // 80 / 80 test cases passed.
    // 70 ms
    public class Solution {
        public int subarraySum(int[] nums, int k) {
            int ret = 0, sum= 0;
            HashMap<Integer, Integer> map = new HashMap();
            map.put(0,1);

            for(int i=0;i<nums.length;i++){
                sum += nums[i];
                if(map.containsKey(sum - k)) ret += map.get(sum-k);

                if(!map.containsKey(sum)) map.put(sum, 0);
                map.put(sum, map.get(sum) + 1);
            }
            return ret;
        }
    }
}
