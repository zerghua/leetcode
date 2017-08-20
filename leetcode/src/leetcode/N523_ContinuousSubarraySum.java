package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Hua on 5/11/2017.

 Given a list of non-negative numbers and a target integer k,
 write a function to check if the array has a continuous
 subarray of size at least 2 that sums up to the multiple of k,
 that is, sums up to n*k where n is also an integer.

 Example 1:

 Input: [23, 2, 4, 6, 7],  k=6
 Output: True
 Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

 Example 2:

 Input: [23, 2, 6, 4, 7],  k=6
 Output: True
 Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

 Note:

 The length of the array won't exceed 10,000.
 You may assume the sum of all the numbers is in the range of a signed 32-bit integer.

 */
public class N523_ContinuousSubarraySum {
    // Facebook
    // tricky solution, similar to N560, subarray sum Equals K
    // math: (x + n*k) mod k = x ,which x can be [0,k-1].
    // 75 / 75 test cases passed.
    // 17 ms
    public class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap();
            map.put(0,-1);
            int sum = 0;
            for(int i=0; i<nums.length; i++){
                sum += nums[i];
                if(k!= 0) sum %= k; // important math here
                if(!map.containsKey(sum))map.put(sum, i);
                if(i - map.get(sum) > 1) return true;  // make sure at least 2 items
            }
            return false;
        }
    }
}
