package leetcode;
import java.util.*;

/**
The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the tota l number of bits in the code,
 print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, ret urn [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2

 * n=3, result expects: [0,1,3,2,6,7,5,4]
 * https://en.wikipedia.org/wiki/Gray_code
 *
 */
public class N89_GrayCode {
    // 1 ms
    // f(n) += reverse(f(n-1)) + 2^(n-1)
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        int k=1;
        for(int i=1; i<=n; i++){
            int ret_length=ret.size();
            for(int j=ret_length-1;j>=0;j--){
               ret.add(ret.get(j)+k);
            }
            k <<= 1;
        }
        return ret;
    }
}
