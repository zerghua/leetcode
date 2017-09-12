package leetcode;

/**
 * Created by HuaZ on 7/22/2017.

 Given an input string, reverse the string word by word.
 A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces
 and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?

 */
public class N186_ReverseWordsinaStringII {
    // facebook, uber, Microsoft  (Premium)
    // 17 / 17 test cases passed.
    // 3 ms
    // reverse and reverse
    public class Solution {
        public void reverseWords(char[] s) {
            reverse(s, 0, s.length - 1);
            int i=0, j=0;
            while(j < s.length){
                if(s[j] == ' '){
                    reverse(s, i, j-1);
                    i = j+1;
                }
                j++;
            }
            reverse(s, i, s.length -1);
        }

        public void reverse(char[] s, int i, int j){
            while(i<j){
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
                i++; j--;
            }
        }
    }
}
