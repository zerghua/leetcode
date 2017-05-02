package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 5/2/2017.

 Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2),
 ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

 Example 1:

 Input: [1,4,3,2]

 Output: 4
 Explanation: n is 2, and the maximum sum of pairs is 4.

 Note:

 n is a positive integer, which is in the range of [1, 10000].
 All the integers in the array will be in the range of [-10000, 10000].


 */
public class N561_ArrayPartitionI {
    // 81 / 81 test cases passed.
    // 42 ms
    // math, sort
    public class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int ret = 0;
            for(int i=0;i<nums.length; i+=2) ret += nums[i] ;
            return ret;
        }
    }
}
