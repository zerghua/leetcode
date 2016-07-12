package leetcode;

/**
 * Created by Hua on 7/11/2016.
 *
 *  Given an array of integers, every element appears three times except for one.
 *  Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity.
 Could you implement it without using extra memory?
 *
 */
public class N137_SingleNumber2 {
    //5 ms
    // bit manipulation
    // sum of each bit, should be 3n + (0 or 1),  mod 3 is the result.
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int a: nums){
                count += ((a >> i) & 1);
            }
            ret |= ((count%3) << i);
        }
        return ret;
    }
}
