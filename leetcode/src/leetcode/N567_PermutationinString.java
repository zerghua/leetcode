package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 5/1/2017.

 Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words,
 one of the first string's permutations is the substring of the second string.

 Example 1:

 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").

 Example 2:

 Input:s1= "ab" s2 = "eidboaoo"
 Output: False

 Note:

 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].
 */




public class N567_PermutationinString {
    // a window with hashtable to match second string, and slide it one position each time.
    // 102 / 102 test cases passed.
    // Runtime: 36 ms
    public class Solution {
        public boolean checkInclusion(String s1, String s2) {
            char[] w1 = new char[26];
            for(int i=0; i< s1.length(); i++) w1[s1.charAt(i) - 'a']++;

            char[] w2 = new char[26];
            for(int i=0; i< s2.length(); i++){
                w2[s2.charAt(i) - 'a']++;
                if(i >= s1.length()) w2[s2.charAt(i - s1.length()) - 'a']--;
                if(Arrays.equals(w1, w2)) return true;
            }
            return false;
        }
    }
}
