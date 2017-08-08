package leetcode;

import java.util.HashMap;

/**
 * Created by Hua on 5/10/2017.

 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Example 1:

 Input: [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

 Example 2:

 Input: [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

 Note: The length of the given binary array will not exceed 50,000.

 */
public class N525_ContiguousArray {
    // Facebook
    // similar to N560 subarray sum equals k
    // The idea is to change 0 in the original array to -1. Thus, if we find SUM[i, j] == 0 then we know there are even
    // number of -1 and 1 between index i and j. Also put the sum to index mapping to a HashMap to make search faster.
    // 555 / 555 test cases passed.
    // 84 ms
    public class Solution {
        public int findMaxLength(int[] nums) {
            for(int i=0; i<nums.length; i++){
                if(nums[i] == 0) nums[i] = -1;
            }

            HashMap<Integer, Integer> map = new HashMap(); // record sum at this index
            map.put(0, -1);
            int sum = 0, max = 0;

            for(int i=0; i< nums.length; i++){
                sum += nums[i];
                if(map.containsKey(sum)) max = Math.max(max, i - map.get(sum));
                else map.put(sum, i);
            }
            return max;
        }
    }

}
