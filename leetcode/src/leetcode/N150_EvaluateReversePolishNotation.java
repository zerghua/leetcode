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
}
