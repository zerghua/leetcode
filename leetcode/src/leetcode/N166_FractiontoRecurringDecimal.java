package leetcode;

import java.util.HashMap;

/**
 * Created by HuaZ on 7/21/2016.

 Given two integers representing the numerator and denominator of a fraction,
 return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".

 Hint:

 No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
 Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
 Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.

 */
public class N166_FractiontoRecurringDecimal {
    // 6 ms
    // math, hash table
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        if((numerator ^ denominator)<0) sb.append("-");  // sign
        sb.append(num/den);              // decimal part
        long remainder = num % den;
        if(remainder == 0) return sb.toString();
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while(!map.containsKey(remainder)){
            map.put(remainder, sb.length());  //sequence should not be changed here.
            sb.append(10*remainder/den);
            remainder = 10*remainder % den;
        }
        sb.insert(map.get(remainder), "(");
        sb.append(")");
        return sb.toString().replace("(0)","");
    }
}
