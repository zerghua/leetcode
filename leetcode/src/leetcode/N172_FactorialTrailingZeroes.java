package leetcode;

/**
 * Created by Hua on 5/21/2016.

 Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 */
public class N172_FactorialTrailingZeroes {
    // Bloomberg
    //1 ms
    // count number of 5s, equal trailing zeros
    // time o(log5)
    public int trailingZeroes(int n) {
        int ret = 0;
        while(n>0){
            int k=n/5;
            ret += k;
            n=k;
        }
        return ret;
    }
}
