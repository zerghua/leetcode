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
    // Pocket Gems, Google
    // slow, but very easy to understand.
    // find the largest window size = max char count + k
    // 37 / 37 test cases passed.  on 8/18/2017
    // 821 ms
    public class Solution {
        public int characterReplacement(String s, int k) {
            int ret = 0, left =0;
            char[] a = s.toCharArray();
            for(int right=0;right<a.length;right++){
                while(maxCharCount(a, left, right) + k < right - left + 1) { // when max char count + k < window size, then down size window
                    left++;
                }
                ret = Math.max(ret, right-left+1);  //update ret to window size
            }
            return ret;
        }

        public int maxCharCount(char[] a, int left, int right){
            int max = 0;
            int[] map = new int[128];
            for(int i=left; i<=right; i++){
                max = Math.max(max, ++map[a[i]]);
            }
            return max;
        }
    }


    // sliding window + hashtable
    // the problem is equal to find a window which has (longest repeating chars + k)
    // window = (maxSizeOfRepeatingChars + k)
    // this is greedy, take example:
    // k=1  AABACCDCC ->  |AABA|CCDCC  ->  |AABAC|CDCC  ->  A|ABACC|DCC ->  AA|BACCD|CC  -> AAB|ACCDC|C -> AABA|CCDCC|
    //      max =0        max=3,window=4   max=3,window=5   max=3,window=5  max=3,window=5 max=3,window=5  max=4,window=5
    // 11 ms 37 / 37 test cases passed.
    public class Solution2 {
        public int characterReplacement(String s, int k) {
            int ret = 0, maxRepeatChar=0, left =0;
            int[] map = new int[128];
            char[] a = s.toCharArray();
            for(int i=0;i<a.length;i++){
                maxRepeatChar = Math.max(maxRepeatChar,  ++map[a[i]]); // add window
                while(k + maxRepeatChar < i-left+1) { // find the largest window size = maxCharCount + k
                    map[a[left]]--;
                    left++;
                }
                ret = Math.max(ret, i-left+1);  //update ret to window size
            }
            return ret;
        }
    }
}
