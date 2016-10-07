package leetcode;

/**
 * Created by Hua on 5/23/2016.

 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.
 Have you thought about this?

 Here are some good questions to ask before coding.
 Bonus points for you if you have already thought through this!

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow?
 Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
 How should you handle such cases?

 For the purpose of this problem, assume that your function returns 0
 when the reversed integer overflows.

 */
public class N7_ReverseInteger {
    //2 ms
    // 1. negative number?
    // 2. trailing zeros
    // 3. int overflow.
    public int reverse(int x) {
        int ret = 0;
        while(x!=0){
            if(ret > Integer.MAX_VALUE/10 || ret < Integer.MIN_VALUE/10)
                return 0; //int overflow

            ret = ret*10 + x%10;
            x /= 10;
        }
        return ret;
    }

    // added on 10/7/2016
    // 60 ms 1032 / 1032 test cases passed.
    public class Solution {
        public int reverse(int x) {
            int ret = 0;
            while(x != 0){
                if(Math.abs(ret) > Integer.MAX_VALUE/10) return 0; // handle overflow/underflow
                ret = ret*10 + x%10;
                x /= 10;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        N7_ReverseInteger x= new N7_ReverseInteger();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE*10);
        x.reverse(1);
    }

}
