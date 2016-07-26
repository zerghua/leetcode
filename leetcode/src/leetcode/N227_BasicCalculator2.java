package leetcode;

import java.util.Stack;

/**
 * Created by HuaZ on 7/26/2016.

 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators
 and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:

 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5


 */
public class N227_BasicCalculator2 {
    // key note: only non-negative numbers
    // corner case: single number
    // 43 ms
    // stack
    public int calculate(String s) {
        if(s == null || s.length() ==0) return 0;
        int ret = 0, num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)))  num = num*10 + s.charAt(i) - '0';
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length()-1){
                if(sign == '+') stack.push(num);
                else if(sign == '-') stack.push(-num);
                else if(sign == '*') stack.push(stack.pop() * num);
                else if(sign == '/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        for(int i:stack) ret+= i;
        return ret;
    }
}
