package leetcode;

/**
 * Created by HuaZ on 7/16/2016.

 Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.

 -2147483648
 2

 */
public class N29_DivideTwoIntegers {
    // no company
    // 3 ms
    // detail of how Java math.abs() works
    //  Note that if the argument is equal to the value of Integer.MIN_VALUE,
    //  the most negative representable int value, the result is that same value, which is negative.
    // https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html#abs(long)
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor ==-1))
            return Integer.MAX_VALUE;

        boolean isNegative = (dividend >0 && divisor<0) ||  (dividend <0 && divisor>0);
        long dd = Math.abs((long)dividend);
        long ds = Math.abs((long)divisor);

        int ret = 0;
        while(dd >= ds){
            long tmp = ds, multiple = 1;
            while(dd >= (tmp << 1)){
                tmp <<= 1;
                multiple <<= 1;
            }
            dd -= tmp;
            ret += multiple;
        }
        return isNegative==false? ret: -ret;
    }
}
