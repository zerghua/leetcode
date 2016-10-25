package leetcode;

import java.util.Stack;

/**
 * Created by Hua on 10/25/2016.

 Given a non-negative integer num represented as a string,
 remove k digits from the number so that the new number is the smallest possible.

 Note:

 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.

 Example 1:

 Input: num = "1432219", k = 3
 Output: "1219"
 Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

 Example 2:

 Input: num = "10200", k = 1
 Output: "200"
 Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

 Example 3:

 Input: num = "10", k = 2
 Output: "0"
 Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 https://discuss.leetcode.com/topic/59646/straightforward-java-solution-using-stack

 */
public class N402_RemoveKDigits {
    // remove larger number in stack, impressive
    // 60 ms 33 / 33 test cases passed.
    public class Solution {
        public String removeKdigits(String num, int k) {
            if(k==num.length()) return "0";
            Stack<Character> stack = new Stack();
            char[] a = num.toCharArray();

            for(int i=0;i<num.length();i++){
                while(k> 0 && !stack.isEmpty() && stack.peek() > a[i]){   // remove larger number in stack
                    stack.pop();
                    k--;
                }
                stack.push(a[i]);
            }
            while(k-->0) stack.pop();  // case like "1111"  or "12345"

            // construct ret reversely
            StringBuilder ret = new StringBuilder();
            while(!stack.isEmpty()) ret.insert(0,stack.pop());

            while(ret.length() >1 && ret.charAt(0) == '0') ret.deleteCharAt(0); // remove leading zeros
            return ret.toString();
        }
    }

}
