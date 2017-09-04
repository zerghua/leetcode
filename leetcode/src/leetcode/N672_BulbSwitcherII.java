package leetcode;

/**
 * Created by HuaZ on 9/4/2017.

 There is a room with n lights which are turned on initially and 4 buttons on the wall.
 After performing exactly m unknown operations towards buttons,
 you need to return how many different kinds of status of the n lights could be.

 Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:

 Flip all the lights.
 Flip lights with even numbers.
 Flip lights with odd numbers.
 Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...

 Example 1:

 Input: n = 1, m = 1.
 Output: 2
 Explanation: Status can be: [on], [off]

 Example 2:

 Input: n = 2, m = 1.
 Output: 3
 Explanation: Status can be: [on, off], [off, on], [off, off]

 Example 3:

 Input: n = 3, m = 1.
 Output: 4
 Explanation: Status can be: [off, on, off], [on, off, on], [off, off, off], [off, on, on].

 Note: n and m both fit in range [0, 1000].


 observations:
 4 different operations:
 1. flip all(1,2,3)
 2. flip odd(1,3)
 3. flip even(2)
 4. flip 3k+1(1)

 we only need to consider at most 3 bits(init are all 1), the rest are just repeating:
 1. n == 0 || m == 0, return 1

 2. n == 1, m >= 1, bits can be 0(flip odd) or 1(flip even)

 3. n == 2; m == 1, bits can be 00(flip all), 01(flip odd), 10(flip even);   == 3
            m >= 2, with extra  11(flip all)                                 == 4

 4. n == 3, m == 1, bits can be 000(flip all), 010(flip odd), 101(flip even), 011(flip 3k+1);  == 4
            m == 2, with extra  100(flip 3k+1),110(flip 3k+1),111(flip,3k+1), 111(flip 3K+1);  == 7
            m >= 3, with extra                 100(flip even)                                  == 8



 */
public class N672_BulbSwitcherII {
    // 80 / 80 test cases passed.
    // 6 ms
    // math, generalize pattern
    class Solution {
        public int flipLights(int n, int m) {
            if(n == 0 || m == 0) return 1;
            if(n == 1) return 2;
            if(n == 2) return m == 1? 3 : 4;
            if(m == 1) return 4;
            return m == 2 ? 7 : 8;
        }
    }
}
