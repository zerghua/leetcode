package leetcode;
/*
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity.
Could you implement it using only constant extra space complexity?

 */
import java.math.BigInteger;

public class N268_MissingNumber {
	//16 ms
    public int missingNumber(int[] nums) {
        BigInteger ret = new BigInteger("0");
        for(int i=0;i<nums.length;i++){
        	ret = ret.add(BigInteger.valueOf(i+1-nums[i]));
        }
    	return ret.intValue();
    }

    // bit manipulation added on 9/23/2016
    // a^b^b = a
    // 2 ms  121 / 121 test cases passed.
    public class Solution {
        public int missingNumber(int[] nums) {
            int ret = nums.length;
            for(int i=0;i<nums.length;i++){
                ret ^= i ^ nums[i];
            }
            return ret;
        }
    }
}
