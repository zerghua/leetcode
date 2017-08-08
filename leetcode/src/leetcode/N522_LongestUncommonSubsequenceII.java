package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 5/11/2017.

 Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence
 is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence
 of the other strings.

 A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the
 order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is
 a subsequence of any string.

 The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence.
 If the longest uncommon subsequence doesn't exist, return -1.

 Example 1:

 Input: "aba", "cdc", "eae"
 Output: 3

 Note:

 All the given strings' lengths will not exceed 10.
 The length of the given list will be in the range of [2, 50].

 */
public class N522_LongestUncommonSubsequenceII {
    // Google
    // Suppose we have some candidate X. We only need to check whether X is not a subsequence of any of the
    // other words Y. To save some time, we could have quickly ruled out Y when len(Y) < len(X), either by
    // adding "if len(w1) > len(w2): return False" or enumerating over A[:i] (and checking neighbors for equality.)
    // However, the problem has such small input constraints that this is not required.

    //We want the max length of all candidates with the desired property, so we check candidates in descending order
    // of length. When we find a suitable one, we know it must be the best global answer.

    // similar to 524, Longest Word in Dictionary through deleting.
    // 98 / 98 test cases passed.
    // 97 ms
    public class Solution {
        public int findLUSlength(String[] strs) {
            Arrays.sort(strs, (String o1, String o2) -> o2.length() - o1.length()); // sort by length reverse order
            for(int i=0;i<strs.length;i++){
                boolean isAllSubSequence = true;
                for(int j=0;j< strs.length;j++){
                    if(i == j ) continue;
                    if(isSubSeq(strs[i], strs[j])) {
                        isAllSubSequence = false;
                        break;
                    }
                }
                if(isAllSubSequence) return strs[i].length();
            }
            return -1;
        }

        // return if s1 is the subsequence of s2
        // go through s2, to check if delete some chars from s2 can be s1
        public boolean isSubSeq(String s1, String s2){
            int i=0;
            for(char c: s2.toCharArray()){
                if(i< s1.length() && c == s1.charAt(i)) i++;
            }
            return i == s1.length();
        }
    }
}
