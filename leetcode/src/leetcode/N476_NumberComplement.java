package leetcode;

/**
 * Created by Hua on 5/10/2017.

 Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 Note:

 The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 You could assume no leading zero bit in the integer’s binary representation.

 Example 1:

 Input: 5
 Output: 2
 Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

 Example 2:

 Input: 1
 Output: 0
 Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

 */
public class N476_NumberComplement {
    // 149 / 149 test cases passed.
    // 17 ms
    public class Solution {
        public int findComplement(int num) {
            int sum = 0, bit=0;
            while(sum< num){
                sum += Math.pow(2, bit);
                bit++;
            }
            return sum - num;
        }
    }
}
