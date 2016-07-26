package leetcode;

import java.util.Stack;

/**
 * Created by HuaZ on 7/25/2016.

 Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ),
 the plus + or minus sign -, non-negative integers and empty spaces .

 You may assume that the given expression is always valid.

 Some examples:

 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23

 Note: Do not use the eval built-in library function.

 */
public class N224_BasicCalculator {
    // 31 ms
    // stack, hard on how to get the code done.
    public int calculate(String s) {
        int ret = 0, sign =1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int sum = s.charAt(i) - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    sum = sum*10 + s.charAt(i+1) - '0';
                    i++;
                }
                ret += sum*sign;
            }
            else if(s.charAt(i) == '+') sign = 1;
            else if(s.charAt(i) == '-') sign = -1;
            else if(s.charAt(i) == '('){
                stack.push(ret);
                stack.push(sign);
                sign = 1;
                ret = 0;
            }
            else if(s.charAt(i) == ')') ret = ret * stack.pop() + stack.pop();
        }
        return ret;
    }

}
