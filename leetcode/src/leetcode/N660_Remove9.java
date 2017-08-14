package leetcode;

/**
 * Created by Hua on 8/14/2017.

 Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...

 So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...

 Given a positive integer n, you need to return the n-th integer after removing. Note that 1 will be the first integer.

 Example 1:

 Input: 9
 Output: 10

 Hint: n will not exceed 9 x 10^8.


 As the problem want to move every digit has 9, which means 1 2 3 4 5 6 7 8 10 11 12 13 14 15 16 17 18 20...
 That is once you count to 8, we need jump to 10( which luckily 9 in 9 based )...
 And when change number in 9 base, it will not appear 9 any more...

 It only useful to move 9, and not suit for other digit, such as 8..
 since in 8 base, will get list as this : 1 2 3 4 5 6 7 8 10 11.. will pass 9..

 */
public class N660_Remove9 {
    // Math, 10 base to 9 base
    // 102 / 102 test cases passed.
    // 8 ms
    public class Solution {
        public int newInteger(int n) {
            return Integer.parseInt(Integer.toString(n, 9));
        }
    }

    // 102 / 102 test cases passed.
    // 7 ms
    public class Solution2 {
        public int newInteger(int n) {
            int ret = 0, pow = 1;
            while(n > 0){
                ret += n % 9 * pow;
                pow *= 10;
                n /= 9;
            }
            return ret;
        }
    }
}
