package leetcode;

import java.util.Stack;

/**
 * Created by HuaZ on 11/26/2016.

 Your task is to calculate ab mod 1337 where a is a positive integer and b is
 an extremely large positive integer given in the form of an array.

 Example1:

 a = 2
 b = [3]

 Result: 8

 Example2:

 a = 2
 b = [1,0]

 Result: 1024


 */
public class N372_SuperPow {
    // 18 ms 54 / 54 test cases passed.
    // stack and recursion.
    public class Solution {
        private final int M = 1337;
        public int superPow(int a, int[] b) {
            Stack<Integer> stack = new Stack();
            for(int e: b) stack.push(e);
            return superPow(a, stack);
        }

        public int superPow(int a, Stack<Integer> stack){
            if(stack.isEmpty()) return 1;
            int last = stack.pop();
            int firstPart = superPow(a,stack);
            return pow(firstPart, 10) * pow(a,last) % M;
        }

        // return a^k % M
        public int pow(int a, int k){
            if(k==0) return 1;
            a %= M;
            if( k%2 == 1) return a * pow(a*a, k/2) % M;
            return pow(a*a, k/2) % M;
        }
    }
}
