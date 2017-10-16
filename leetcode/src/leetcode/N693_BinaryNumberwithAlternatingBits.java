package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/15/2017.

 Given a positive integer, check whether it has alternating bits:
 namely, if two adjacent bits will always have different values.

 Example 1:

 Input: 5
 Output: True
 Explanation:
 The binary representation of 5 is: 101

 Example 2:

 Input: 7
 Output: False
 Explanation:
 The binary representation of 7 is: 111.

 Example 3:

 Input: 11
 Output: False
 Explanation:
 The binary representation of 11 is: 1011.

 Example 4:

 Input: 10
 Output: True
 Explanation:
 The binary representation of 10 is: 1010.


 */
public class N693_BinaryNumberwithAlternatingBits {
    // my contest solution
    // 204 / 204 test cases passed.
    // 14 ms
    class Solution {
        public boolean hasAlternatingBits(int n) {
            int last = n & 1;
            n >>>= 1;
            while(n != 0){
                int cur = (n & 1);
                if((cur ^ last) != 1) return false;
                n >>>= 1;
                last = cur;
            }
            return true;
        }
    }


    // others solution
    // check if adjacent bit are not the same
    // 204 / 204 test cases passed.
    // 13 ms
    class Solution2 {
        public boolean hasAlternatingBits(int n) {
            String bits = Integer.toBinaryString(n);
            for (int i = 0; i < bits.length() - 1; i++) {
                if (bits.charAt(i) == bits.charAt(i+1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
