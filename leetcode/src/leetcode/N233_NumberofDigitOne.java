package leetcode;

/**
 * Created by HuaZ on 7/22/2016.
 *
 Given an integer n, count the total number of digit 1 appearing
 in all non-negative integers less than or equal to n.

 For example:
 Given n = 13,
 Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

 Hint:

 Beware of overflow.



 */
public class N233_NumberofDigitOne {
    // no company
    // 0 ms
    // math, be aware of overflow
    // https://discuss.leetcode.com/topic/18972/ac-short-java-solution
    public int countDigitOne(int n) {
        if(n<0) return 0;
        int ret = 0;
        for(long i=1; i<=n; i*=10){
            long r = n/i,  m = n%i;
            ret += (r+8)/10*i + (r%10 == 1 ? m+1 : 0);
        }
        return ret;
    }
}
