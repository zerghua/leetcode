package leetcode;

/**
 * Created by Hua on 5/19/2016.
 *
 Given an integer, write a function to determine if it is a power of two.

 */
public class N231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<1) return false;
        while(n!=1){
            if(n%2 !=0) return false;
            n = n/2;
        }
        return true;
    }
}
