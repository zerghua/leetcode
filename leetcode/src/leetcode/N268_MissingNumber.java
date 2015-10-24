package leetcode;

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
}
