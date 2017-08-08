package leetcode;

/**
 * Created by Hua on 5/23/2017.

 Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
 so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

 Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s.
 In particular, your input is the string p and you need to output the number of different
 non-empty substrings of p in the string s.

 Note: p consists of only lowercase English letters and the size of p might be over 10000.

 Example 1:

 Input: "a"
 Output: 1

 Explanation: Only the substring "a" of string "a" is in the string s.

 Example 2:

 Input: "cac"
 Output: 2
 Explanation: There are two substrings "a", "c" of string "cac" in the string s.

 Example 3:

 Input: "zab"
 Output: 6
 Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.



 After failed with pure math solution and time out with DFS solution, I finally realized that this is a DP problem...
 The idea is, if we know the max number of unique substrings in p ends with 'a', 'b', ..., 'z',
 then the summary of them is the answer. Why is that?

 The max number of unique substring ends with a letter equals to the length of max contiguous substring ends
 with that letter. Example "abcd", the max number of unique substring ends with 'd' is 4,
 apparently they are "abcd", "bcd", "cd" and "d".

 If there are overlapping, we only need to consider the longest one because it covers all the possible substrings.
 Example: "abcdbcd", the max number of unique substring ends with 'd' is 4 and all substrings formed by
 the 2nd "bcd" part are covered in the 4 substrings already.

 No matter how long is a contiguous substring in p, it is in s since s has infinite length.
 Now we know the max number of unique substrings in p ends with 'a', 'b', ..., 'z' and those substrings are all in s.
 Summary is the answer, according to the question.

 Hope I made myself clear...


 */
public class N467_UniqueSubstringsinWraparoundString {
    // MAQ software
    // tricky but interesting problem
    // 81 / 81 test cases passed.
    // 29 ms
    public class Solution {
        public int findSubstringInWraproundString(String p) {
            if(p == null || p.length() == 0) return 0;
            int[] count = new int[26];
            int maxSoFar = 1;
            count[p.charAt(0) - 'a'] = 1;

            for(int i=1; i<p.length(); i++){
                if(p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i-1) - p.charAt(i) == 25) maxSoFar++;
                else maxSoFar = 1;

                count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], maxSoFar);
            }

            int ret = 0;
            for(int i : count) ret += i;
            return ret;
        }
    }
}
