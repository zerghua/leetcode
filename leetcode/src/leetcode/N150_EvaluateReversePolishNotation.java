package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/10/2016.

 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


 */
public class N150_EvaluateReversePolishNotation {
    //19 ms stack
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        List<String> operaters = Arrays.asList("+", "-", "*", "/");
        for(String c : tokens){
            if(operaters.contains(c)){
                int b= Integer.valueOf(stack.pop());
                int a= Integer.valueOf(stack.pop());
                int ret = 0;
                if(c.equals("+")) ret = a+b;
                else if(c.equals("-")) ret = a-b;
                else if(c.equals("*")) ret = a*b;
                else if(c.equals("/")) ret = a/b;

                stack.push(String.valueOf(ret));
            }else stack.push(c);
        }

        return Integer.valueOf(stack.peek());
    }

    // stack<Integer> instead of stack<String> added on 10/9/2016
    // 15 ms 20 / 20 test cases passed.
    // Integer.parseInt(s) returns primitive int however Integer.valueOf() returns Integer object.
    // Integer.valueOf(s) equals new Integer(Integer.parseInt(s))
    public class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack();
            HashSet<String> operators = new HashSet(Arrays.asList("+","-","*","/")); //remember use String than char.
            for(String token: tokens){
                if(operators.contains(token)){
                    int b = stack.pop();
                    int a = stack.pop();
                    if(token.equals("+")) stack.push(a+b);
                    else if (token.equals("-")) stack.push(a-b);
                    else if (token.equals("*")) stack.push(a*b);
                    else stack.push(a/b);
                }else stack.push(Integer.valueOf(token));
            }
            return stack.pop();
        }
    }
}
