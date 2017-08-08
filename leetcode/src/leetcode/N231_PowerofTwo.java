package leetcode;

/**
 * Created by Hua on 5/19/2016.
 *
 Given an integer, write a function to determine if it is a power of two.

 */
public class N231_PowerofTwo {
    // Google
    public boolean isPowerOfTwo(int n) {
        if(n<1) return false;
        while(n!=1){
            if(n%2 !=0) return false;
            n = n/2;
        }
        return true;
    }

    // version 2 added on 9/21/2016
    // 2 ms  1108 / 1108 test cases passed.
    public class Solution {
        public boolean isPowerOfTwo(int n) {
            return n>0 && (n & n-1) == 0 ;
        }
    }
}
