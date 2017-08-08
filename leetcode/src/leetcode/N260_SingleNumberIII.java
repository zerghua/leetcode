package leetcode;

/**
 * Created by HuaZ on 12/7/2016.

 Given an array of numbers nums, in which exactly two elements appear only once and
 all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:

 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only
 constant space complexity?

 https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations/2

 */
public class N260_SingleNumberIII {
    // no company
    // 1 ms 30 / 30 test cases passed.
    // bit manipulation
    public class Solution {
        public int[] singleNumber(int[] nums) {
            int mask = 0;
            for(int n: nums) mask ^= n;
            mask = mask & (-mask); // get one bit

            int[] ret = {0,0};
            for(int n: nums){
                if((mask & n) == 0) ret[0] ^= n;
                else ret[1] ^= n;
            }
            return ret;
        }
    }
}
