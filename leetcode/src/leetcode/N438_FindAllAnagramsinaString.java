package leetcode;

/**
 * Created by HuaZ on 10/23/2016.
 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p
 will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".

 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".


 */
import java.util.*;
public class N438_FindAllAnagramsinaString {
    // Amazon
    // sliding window size p and hashtable
    // 35 ms 29 / 29 test cases passed.
    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ret = new ArrayList();
            if(p.length() > s.length()) return ret;
            int[] pArray = new int[128];
            for(char e:p.toCharArray()) pArray[e]++;
            int target = Arrays.hashCode(pArray);

            int left = 0;
            int[] map = new int[128];
            char[] a = s.toCharArray();
            for(int i=0;i<p.length();i++) map[a[i]]++;
            if(Arrays.hashCode(map) == target) ret.add(left);

            for(int i=p.length();i<s.length();i++){
                map[a[left]]--;
                map[a[i]]++;
                left++;
                if(Arrays.hashCode(map) == target) ret.add(left);
            }
            return ret;
        }
    }


    // concise code
    // keep a window of length p
    // 15 ms 29 / 29 test cases passed.
    public class Solution2 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ret = new ArrayList();
            if(p.length() > s.length()) return ret;
            int[] map = new int[128];
            for(char c: p.toCharArray())map[c]++;

            int left=0, right=0, count=p.length();
            char[] a = s.toCharArray();
            while(right<s.length()){
                if(map[a[right++]]-- > 0) count--;
                if(right-left>p.length() && map[a[left++]]++>=0) count++;
                if(count == 0) ret.add(left);
            }
            return ret;
        }
    }


    // added on 12/1/2016
    // 21 ms 34 / 34 test cases passed.
    public class Solution3 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ret = new ArrayList();
            if(p.length() > s.length()) return ret;
            int[] map = new int[128];
            for(char c: p.toCharArray())map[c]++;

            int left=0, right=0, count=p.length();
            char[] a = s.toCharArray();
            while(right<s.length()){
                if(map[a[right++]]-- > 0) count--;
                if(count == 0) ret.add(left);
                if(right-left == p.length() && map[a[left++]]++>=0) count++;
            }
            return ret;
        }
    }
}
