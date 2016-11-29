package leetcode;

/**
 * Created by HuaZ on 11/28/2016.

 There is a list of sorted integers from 1 to n. Starting from left to right,
 remove the first number and every other number afterward until you reach the end of the list.

 Repeat the previous step again, but this time from right to left,
 remove the right most number and every other number from the remaining numbers.

 We keep repeating the steps again, alternating left to right and right to left,
 until a single number remains.

 Find the last number that remains starting with a list of length n.

 Example:

 Input:
 n = 9,
 1 2 3 4 5 6 7 8 9
 2 4 6 8
 2 6
 6

 Output:
 6

 https://discuss.leetcode.com/topic/59293/java-easiest-solution-o-logn-with-explanation

 */
public class N390_EliminationGame {
    // 92 ms  3377 / 3377 test cases passed.
    // o(logn) solution.
    // math and coding.
    public class Solution {
        public int lastRemaining(int n) {
            boolean isLeft = true;
            int head = 1, step = 1, remain = n;
            while(remain > 1){
                if(isLeft || remain %2 == 1) head += step;
                isLeft = !isLeft;
                step *= 2;
                remain /= 2;
            }
            return head;
        }
    }
}
