package leetcode;

/**
 * Created by Hua on 7/5/2017.

 Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.

 Example 1:

 Input: 5
 Output: True
 Explanation: 1 * 1 + 2 * 2 = 5

 Example 2:

 Input: 3
 Output: False

 */

import java.util.*;
public class N633_SumofSquareNumbers {
    // Linkedin
    // 124 / 124 test cases passed.
    // 151 ms
    // Hashtable
    public class Solution {
        public boolean judgeSquareSum(int c) {
            int num = 0;
            HashSet<Integer> set = new HashSet();
            while(num * num <= c){
                int square = num * num ;
                if(square * 2 == c || set.contains(c - square)) return true;
                set.add(square);
                num++;
            }
            return false;
        }
    }


    // 124 / 124 test cases passed.
    // 25 ms
    // math, test each square root
    public class Solution2 {
        public boolean judgeSquareSum(int c) {
            for (int i=0;i<=Math.sqrt(c);i++)
                if (Math.floor(Math.sqrt(c-i*i)) == Math.sqrt(c-i*i)) return true;
            return false;
        }
    }
}
