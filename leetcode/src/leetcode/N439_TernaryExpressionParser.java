package leetcode;

/**
 * Created by Hua on 7/14/2017.

 Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression.
 You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F
 (T and F represent True and False respectively).

 Note:

 The length of the given string is ≤ 10000.
 Each number will contain only one digit.
 The conditional expressions group right-to-left (as usual in most languages).
 The condition will always be either T or F. That is, the condition will never be a digit.
 The result of the expression will always evaluate to either a digit 0-9, T or F.

 Example 1:

 Input: "T?2:3"

 Output: "2"

 Explanation: If true, then result is 2; otherwise result is 3.

 Example 2:

 Input: "F?1:T?4:5"

 Output: "4"

 Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

 "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
 -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
 -> "4"                                    -> "4"

 Example 3:

 Input: "T?T?F:5:3"

 Output: "F"

 Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

 "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
 -> "F"                                    -> "F"


 */

import java.util.*;
public class N439_TernaryExpressionParser {
    // Snapchat
    // stack
    // 49 / 49 test cases passed.
    // 27 ms
    public class Solution {
        public String parseTernary(String expression) {
            Stack<String> stack = new Stack();
            boolean isPop = false;
            for(int i=expression.length()-1; i>=0; i--){
                if(expression.charAt(i) == ':') continue;
                else if(expression.charAt(i) == '?') isPop = true;
                else if(isPop){
                    isPop = false;
                    String tmp = stack.pop();
                    if(expression.charAt(i) == 'T'){
                        stack.pop();
                        stack.push(tmp);
                    }
                }
                else stack.push(expression.charAt(i) + "");
            }
            return stack.pop();
        }
    }


    // another similar solution
    // 49 / 49 test cases passed.
    // 33 ms
    public class Solution2 {
        public String parseTernary(String expression) {
            if (expression == null || expression.length() == 0) return "";
            Deque<Character> stack = new LinkedList<>();

            for (int i = expression.length() - 1; i >= 0; i--) {
                char c = expression.charAt(i);
                if (!stack.isEmpty() && stack.peek() == '?') {

                    stack.pop(); //pop '?'
                    char first = stack.pop();
                    stack.pop(); //pop ':'
                    char second = stack.pop();

                    if (c == 'T') stack.push(first);
                    else stack.push(second);
                } else {
                    stack.push(c);
                }
            }

            return String.valueOf(stack.peek());
        }
    }
}
