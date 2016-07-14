package leetcode;

/**
 * Created by Hua on 7/12/16.
 *
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?
 *
 */
public class N342_PowerofFour {
    // 2 ms
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;

        while(num!=1){
            if(num%4 != 0) return false;
            num /=4 ;
        }
        return true;
    }





}
