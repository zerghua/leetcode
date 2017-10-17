package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/16/2017.

 Give a string s, count the number of non-empty (contiguous) substrings
 that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings
 are grouped consecutively.

 Substrings that occur multiple times are counted the number of times they occur.

 Example 1:

 Input: "00110011"
 Output: 6
 Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's:
 "0011", "01", "1100", "10", "0011", and "01".

 Notice that some of these substrings repeat and are counted the number of times they occur.

 Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.

 Example 2:

 Input: "10101"
 Output: 4
 Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.

 Note:
 s.length will be between 1 and 50,000.
 s will only consist of "0" or "1" characters.

 */
public class N696_CountBinarySubstrings {
    // others solution
    // o(n) string
    // 90 / 90 test cases passed.
    // 35 ms
    class Solution {
        public int countBinarySubstrings(String s) {
            int prevRunLength = 0, curRunLength = 1, res = 0;
            for (int i=1;i<s.length();i++) {
                if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
                else {
                    prevRunLength = curRunLength;
                    curRunLength = 1;
                }
                if (prevRunLength >= curRunLength) res++;
            }
            return res;
        }
    }

    // my AC contest solution
    // if 0, -1, else +1
    // o(n^2)
    // now TLE  on 10/16/2017
    class Solution2 {
        public int countBinarySubstrings(String s) {
            char[] a = s.toCharArray();
            int ret = 0;
            for(int i=0;i<a.length; i++){
                int count = (a[i] == '0' ? -1 : 1);
                int diff = 1;
                for(int j=i+1; j<a.length; j++){
                    if(a[j] != a[j-1]) diff++;
                    if(diff > 2) break;

                    if(a[j] == '0') count -= 1;
                    else count +=1;
                    if(count == 0){
                        ret++;
                        break;
                    }
                }
            }
            return ret;
        }
    }
}
