package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/10/2016.
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
