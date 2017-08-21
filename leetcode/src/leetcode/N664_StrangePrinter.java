package leetcode;

/**
 * Created by Hua on 8/21/2017.

 There is a strange printer with the following two special requirements:

 The printer can only print a sequence of the same character each time.
 At each turn, the printer can print new characters starting from and ending at any places,
 and will cover the original existing characters.

 Given a string consists of lower English letters only,
 your job is to count the minimum number of turns the printer needed in order to print it.

 Example 1:

 Input: "aaabbb"
 Output: 2
 Explanation: Print "aaa" first and then print "bbb".

 Example 2:

 Input: "aba"
 Output: 2
 Explanation: Print "aaa" first and then print "b" from the second place of the string,
 which will cover the existing character 'a'.

 Hint: Length of the given string will not exceed 100.


 similar to N546. Remove Boxes ?
 Explaination: take the test case "aba" as an example,
 first print "aaa", then print "b" to be "aba".
 is equivalent to
 first remove "b" to be "aa", then remove "aa".

 */

public class N664_StrangePrinter {
    // similar to N546. Remove Boxes ?
    // DP
    // others solution, need to review all DP problems again
    // 201 / 201 test cases passed.
    // 64 ms
    class Solution {
        public int strangePrinter(String s) {
            int n = s.length();
            if (n == 0) return 0;

            int[][] dp = new int[101][101];
            for (int i = 0; i < n; i++) dp[i][i] = 1;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    dp[j][j + i] = i + 1;
                    for (int k = j + 1; k <= j + i; k++) {
                        int temp = dp[j][k - 1] + dp[k][j + i];
                        if (s.charAt(k - 1) == s.charAt(j + i)) temp--;
                        dp[j][j + i] = Math.min(dp[j][j + i], temp);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
