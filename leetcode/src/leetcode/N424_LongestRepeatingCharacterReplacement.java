package leetcode;

/**
 * Created by HuaZ on 10/17/2016.

 Given a string that consists of only uppercase English letters,
 you can replace any letter in the string with another letter at most k times.
 Find the length of a longest substring containing all repeating letters
 you can get after performing the above operations.

 Note:
 Both the string's length and k will not exceed 104.

 Example 1:

 Input:
 s = "ABAB", k = 2

 Output:
 4

 Explanation:
 Replace the two 'A's with two 'B's or vice versa.

 Example 2:

 Input:
 s = "AABABBA", k = 1

 Output:
 4

 Explanation:
 Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 The substring "BBBB" has the longest repeating letters, which is 4.

 https://discuss.leetcode.com/topic/63494/java-12-lines-o-n-sliding-window-solution-with-explanation

 */
public class N424_LongestRepeatingCharacterReplacement {
    // Pocket Gems
    // sliding window + hashtable
    // the problem is equal to find a window which has (longest repeating chars + k)
    // window = (maxSizeOfRepeatingChars + k)
    // 11 ms 37 / 37 test cases passed.
    public class Solution {
        public int characterReplacement(String s, int k) {
            int ret = 0, maxRepeatChar=0, left =0;
            int[] map = new int[128];
            char[] a = s.toCharArray();
            for(int i=0;i<a.length;i++){
                maxRepeatChar = Math.max(maxRepeatChar,  ++map[a[i]]); // add window
                while(i-left+1 - maxRepeatChar > k) { // downsize window if needed
                    map[a[left]]--;
                    left++;
                }
                ret = Math.max(ret, i-left+1);  //update ret to window size
            }
            return ret;
        }
    }
}
