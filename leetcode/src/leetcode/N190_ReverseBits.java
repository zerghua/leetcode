package leetcode;

/**
 * Created by huazhang on 7/7/16.

 Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596
 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 Related problem: Reverse Integer

 */
public class N190_ReverseBits {
    // Apple, Airbnb
    // you need treat n as an unsigned value
    // 2ms
    // bit manipulation.
    public int reverseBits(int n) {
        int ret=0;
        for(int i=0;i<32;i++){
            ret = ret << 1 | (n & 1);
            n >>= 1;
        }
        return ret;
    }

    // follow up, use hashtable to store calculated value.

}
