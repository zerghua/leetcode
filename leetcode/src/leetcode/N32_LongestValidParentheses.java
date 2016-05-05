package leetcode;

import java.util.Stack;

/**
 * Created by Hua on 5/4/2016.
 *
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()",
 which has length = 4.





 */

public class N32_LongestValidParentheses {
    //TODO solve corner case: "()(()"   2
    public int longestValidParentheses(String s) {
        int max = 0;
        int local_max = 0;

        // number of left parentheses
        int[] dp = new int[s.length()+1];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                dp[i+1] = dp[i] + 1;
            }else{ //s.charAt(i) == ')'
                if(dp[i] > 0){
                    local_max++;
                    max = Math.max(max, local_max);
                    dp[i+1] = dp[i] - 1;
                }else {
                    local_max = 0;
                }
            }
        }
        return max*2;
    }

    //TLE
    public int longestValidParentheses_stack(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '('){
                stack.pop();
                if(stack.isEmpty()) max = i+1;
                else max = Math.max(max, i-stack.peek());
            }else{
                stack.push(i);
            }
        }
        return max;
    }

    //14 ms
    public int longestValidParentheses_stack2(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')' && !stack.isEmpty() && chars[stack.peek()] == '('){
                stack.pop();
                if(stack.isEmpty()) max = i+1;
                else max = Math.max(max, i-stack.peek());
            }else{
                stack.push(i);
            }
        }
        return max;
    }

}



