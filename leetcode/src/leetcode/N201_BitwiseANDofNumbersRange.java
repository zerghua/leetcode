package leetcode;

/**
 * Created by Hua on 7/10/2016.

 Given a range [m, n] where 0 <= m <= n <= 2147483647,
 return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.

 */
public class N201_BitwiseANDofNumbersRange {
    //TLE 0, 2147483647
    public int rangeBitwiseAnd2(int m, int n) {
        int ret = m;
        for(int i=m+1;i<=n;i++){
            ret &= i;
        }
        return ret;
    }

    // 9 ms
    // bit manipulation
    // find the common part on the left and add 0 back.
    public int rangeBitwiseAnd(int m, int n) {
        int i=0;
        while( n != m){
            n >>= 1;
            m >>= 1;
            i++;
        }
        return (m<<i);
    }

}
