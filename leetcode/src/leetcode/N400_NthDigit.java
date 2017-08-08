package leetcode;

/**
 * Created by Hua on 5/19/2017.

 Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

 Note:
 n is positive and will fit within the range of a 32-bit signed integer (n < 231).

 Example 1:

 Input:
 3

 Output:
 3

 Example 2:

 Input:
 11

 Output:
 0

 Explanation:
 The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

 find the length of the number where the nth digit is from
 find the actual number where the nth digit is from
 find the nth digit and return

 */
public class N400_NthDigit {
    // Google
    // BF is to construct the sequence string and return it's char at index.
    // pure math
    // 70 / 70 test cases passed.
    // 6 ms
    public class Solution {
        public int findNthDigit(int n) {
            int len = 1, start = 1;
            long count = 9;
            while(n > len * count){
                n -= len*count;
                len++;
                start *= 10;
                count *= 10;
            }
            start += (n-1)/len;
            return (start + "").charAt((n-1)%len) - '0';
        }
    }

}
