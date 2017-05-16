package leetcode;

/**
 * Created by Hua on 5/16/2017.

 Given a binary array, find the maximum number of consecutive 1s in this array.

 Example 1:

 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.

 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000

 */
public class N485_MaxConsecutiveOnes {
    // easy array. 0(n)
    // 41 / 41 test cases passed.
    // 9 ms
    public class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int ret = 0, count = 0;
            for(int i: nums){
                if(i == 0){
                    ret = Math.max(ret, count);
                    count = 0;
                }else count++;
            }
            return Math.max(ret, count);
        }
    }

    // better code
    // 41 / 41 test cases passed.
    // 11 ms
    public class Solution2 {
        public int findMaxConsecutiveOnes(int[] nums) {
            int ret = 0, count = 0;
            for(int i: nums){
                if(i == 1){
                    count++;
                    ret = Math.max(ret, count);
                }else count = 0;
            }
            return ret;
        }
    }
}
