package leetcode;

/**
 * Created by Hua on 8/1/2017.

 A message containing letters from A-Z is being encoded to numbers using the following mapping way:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26

 Beyond that, now the encoded string can also contain the character '*',
 which can be treated as one of the numbers from 1 to 9.

 Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

 Also, since the answer may be very large, you should return the output mod 10^9 + 7.

 Example 1:

 Input: "*"
 Output: 9
 Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".

 Example 2:

 Input: "1*"
 Output: 9 + 9 = 18

 Note:

 The length of the input string will fit in range [1, 10^5].
 The input string will only contain the character '*' and digits '0' - '9'.




 Java DP, O(n) time and O(1) space

 The idea for DP is simple when using two helper functions
 ways(i) -> that gives the number of ways of decoding a single character
 and
 ways(i, j) -> that gives the number of ways of decoding the two character string formed by i and j.
 The actual recursion then boils down to :

 f(i) = (ways(i) * f(i+1)) + (ways(i, i+1) * f(i+2))

 The solution to a string f(i), where i represents the starting index,

 f(i) = no.of ways to decode the character at i, which is ways(i) + solve for remainder of the string using recursion f(i+1)
 and
 no.of ways to decode the characters at i and i+1, which is ways(i, i+1) + solve for remainder of the string using recursion f(i+2)

 The base case is ,

 return ways(s.charAt(i)) if(i == j)

 The above recursion when implemented with a cache, is a viable DP solution, but it leads to stack overflow error,
 due to the depth of the recursion. So its better to convert to memoized version.

 For the memoized version, the equation changes to

 f(i) = ( f(i-1) * ways(i) ) + ( f(i-2) *ways(i-1, i) )

 This is exactly the same as the previous recursive version in reverse,

 The solution to a string f(i), where i represents the ending index of the string,

 f(i) = solution to the prefix of the string f(i-1) + no.of ways to decode the character at i, which is ways(i)
 and
 solution to the prefix f(i-2) + no.of ways to decode the characters at i - 1 and i, which is ways(i-1, i)

 */
public class N639_DecodeWaysII {
    // facebook
    // DP, not quite sure.
    // 194 / 194 test cases passed.
    // 79 ms
    public class Solution {
        public int numDecodings(String s) {
            long[] res = new long[2];
            res[0] = ways(s.charAt(0));
            if(s.length() < 2) return (int)res[0];

            res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
            for(int j = 2; j < s.length(); j++) {
                long temp = res[1];
                res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j-1), s.charAt(j))) % 1000000007;
                res[0] = temp;
            }
            return  (int)res[1];
        }

        private int ways(int ch) {
            if(ch == '*') return 9;
            if(ch == '0') return 0;
            return 1;
        }

        private int ways(char ch1, char ch2) {
            String str = "" + ch1 + "" + ch2;
            if(ch1 != '*' && ch2 != '*') {
                if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                    return 1;
            } else if(ch1 == '*' && ch2 == '*') {
                return 15;
            } else if(ch1 == '*') {
                if(Integer.parseInt(""+ch2) >= 0 && Integer.parseInt(""+ch2) <= 6)
                    return 2;
                else
                    return 1;
            } else {
                if(Integer.parseInt(""+ch1) == 1 ) {
                    return 9;
                } else if(Integer.parseInt(""+ch1) == 2 ) {
                    return 6;
                }
            }
            return 0;
        }
    }

}
