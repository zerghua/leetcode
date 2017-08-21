package leetcode;

import java.util.Stack;

/**
 * Created by Hua on 6/7/2016.

 Implement pow(x, n).

 */
public class N50_PowFunction {
    // Google, Facebook
    // bottom-up DFS
    // corner case: n=-2147483648 Integer.MIN_VALUE
    // solution for corner case: x*myPwo(x, -(n+1))
    // 300 / 300 test cases passed.  on 8/21/2017
    // 20 ms
    class Solution {
        public double myPow(double x, int n) {
            if(n == 0) return 1;
            //if(n<0) return 1/myPow(x,-n); // this line will cause stack overflow when n=-2147483648
            if(n<0) return 1/(x*myPow(x,-(n+1)));

            double ret = myPow(x,n/2);
            if(n%2 == 0) return ret*ret;
            else return ret*ret*x;
        }
    }



    // iterative  added on 9/6/2016
    // https://discuss.leetcode.com/topic/40546/iterative-log-n-solution-with-clear-explanation
    // 1 ms  300 / 300 test cases passed.
    public class Solution2 {
        public double myPow(double x, int n) {
            long abs_n = Math.abs((long)n);
            double ret = 1;
            while(abs_n >0){
                if((abs_n & 1) == 1) ret *= x;
                abs_n >>= 1;
                x *=x;
            }
            return n>0? ret: 1/ret;
        }
    }


    /*
    // java.lang.StackOverflowError with input
    // 1.00000   or 2.00000
    // -2147483648
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double ret = myPowHelper(x, Math.abs(n));
        if(n<0) ret = 1.0/ret;
        return ret;
    }

    private double myPowHelper(double x, int n) {
        if(n==1) return x;
        int mid = n/2;
        double ret = myPowHelper(x,mid);
        ret *= ret;
        if(n%2 == 1) ret *= x;
        return ret;
    }

    // iterative
    // Memory Limit Exceeded
    // 1.00000   or 2.00000
    // -2147483648
    public double myPow2(double x, int n) {
        if(n == 0) return 1;
        Stack<Integer> stack = new Stack<>();
        int m = Math.abs(n);
        while(m!=1){
            stack.add(m%2);
            m/=2;
        }
        double ret =x;
        while(!stack.isEmpty()){
            ret *=ret;
            if(stack.pop() == 1) ret*=x;
        }

        if(n<0) ret = 1.0/ret;
        return ret;
    }
*/






}
