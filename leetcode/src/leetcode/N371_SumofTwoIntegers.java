package leetcode;

/**
 * Created by Hua on 8/3/2016.
 Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.

 */
public class N371_SumofTwoIntegers {
    // 0ms, need to revisit.
    public int getSum(int a, int b) {
        while(b!=0){
            int c = a&b;
            a = a^b;
            b = c<<1;
        }
        return a;
    }
}
