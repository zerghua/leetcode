package leetcode;

/**
 * Created by Hua on 8/3/2017.


 Imagine you have a special keyboard with the following keys:

 Key 1: (A): Prints one 'A' on screen.

 Key 2: (Ctrl-A): Select the whole screen.

 Key 3: (Ctrl-C): Copy selection to buffer.

 Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

 Now, you can only press the keyboard for N times (with the above four keys),
 find out the maximum numbers of 'A' you can print on screen.

 Example 1:

 Input: N = 3
 Output: 3
 Explanation:
 We can at most get 3 A's on screen by pressing following key sequence:
 A, A, A

 Example 2:

 Input: N = 7
 Output: 9
 Explanation:
 We can at most get 9 A's on screen by pressing following key sequence:
 A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V

 Note:

 1 <= N <= 50
 Answers will be in the range of 32-bit signed integer.


 examples:

 1 | 1
 2 | 2
 3 | 3
 4 | 4
 5 | 5
 6 | 6
 7 | 9
 8 | 12
 9 | 16
 10 | 20
 11 | 27
 12 | 36
 13 | 48
 14 | 64
 15 | 81


 */
public class N651_4KeysKeyboard {
    // Microsoft, Google
    // Math, find formula by going through examples.
    // 50 / 50 test cases passed.
    // 4 ms
    public class Solution {
        public int maxA(int N) {
            if(N <= 6) return N;
            int[] dp = new int[N+1];
            for(int i=1; i<=6; i++) dp[i] = i;

            for(int i= 7; i<=N; i++){
                dp[i] = Math.max(dp[i-4] * 3 ,  dp[i-5] * 4);
            }
            return dp[N];
        }
    }
}
