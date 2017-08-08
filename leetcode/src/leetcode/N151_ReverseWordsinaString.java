package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/18/2016.

 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.

 click to show clarification.
 Clarification:

 What constitutes a word?
 A sequence of non-space characters constitutes a word.
 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.


 */

public class N151_ReverseWordsinaString {
    // Microsoft, Apple
    //12 ms
    public String reverseWords(String s) {
        String[] a = s.trim().split(" +");
        for(int i=0; i<a.length/2; i++){
            String tmp = a[i];
            a[i] = a[a.length - i -1];
            a[a.length - i -1] = tmp;
        }

        StringBuilder ret = new StringBuilder();
        for(String e: a) ret.append(e + " ");

        return ret.toString().trim();
    }

    // no need to reverse, just push to builder backwards
    // 11 ms
    public String reverseWords2(String s) {
        String[] a = s.trim().split(" +"); // will handle multiple space cases.
        StringBuilder ret = new StringBuilder();
        for(int i=a.length-1; i>=0; i--) ret.append(a[i]+" ");
        return ret.toString().trim();
    }

    // non-split one pass solution added on 10/4/2016
    // 8 ms 22 / 22 test cases passed.
    public class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            int j=s.length();
            for(int i=s.length()-1; i>=0;i--){
                if(s.charAt(i) == ' ') j = i;
                else if(i==0 || s.charAt(i-1) == ' '){
                    if(sb.length() != 0) sb.append(" ");
                    sb.append(s.substring(i,j));
                }
            }
            return sb.toString();
        }
    }
}
