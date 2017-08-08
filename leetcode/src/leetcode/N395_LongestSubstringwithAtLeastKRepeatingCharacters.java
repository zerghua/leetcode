package leetcode;

/**
 * Created by HuaZ on 10/17/2016.
 *
 Find the length of the longest substring T of a given string (consists of lowercase letters only)
 such that every character in T appears no less than k times.

 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.

 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.


 https://discuss.leetcode.com/topic/57735/c-recursive-solution
 */
public class N395_LongestSubstringwithAtLeastKRepeatingCharacters {
    // Baidu
    // divide and conquer, o(nlogn), impressive
    // count each char in String,
    // find first char which has less than K count, split by it, because it can't be the result.
    // 5 ms  24 / 24 test cases passed.
    public class Solution {
        public int longestSubstring(String s, int k) {
            if(s.length() == 0 || k > s.length()) return 0;
            if(k==0) return s.length();
            int[] map = new int[128];
            char[] a = s.toCharArray();
            for(int i=0;i<a.length;i++) map[a[i]]++;

            int index =0;
            while(index<a.length && map[a[index]]>=k) index++;
            if(index == a.length) return a.length;  //return if all chars has at least K count

            //divide
            int left = longestSubstring(s.substring(0,index),k);
            int right = longestSubstring(s.substring(index+1),k);
            return Math.max(left, right);
        }
    }
}
