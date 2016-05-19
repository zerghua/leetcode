package leetcode;

/**
 * Created by Hua on 5/19/2016.

 Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?


 */
public class N326_PowerofThree {
    //19 ms
    public boolean isPowerOfThree(int n) {
        if(n<1) return false;
        while(n!=1){
            if(n%3 !=0) return false;
            n = n/3;
        }
        return true;
    }




}
