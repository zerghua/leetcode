package leetcode;
import java.util.*;
/**
 * Created by HuaZ on 10/17/2016.

 Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t.
 t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string
 by deleting some (can be none) of the characters without disturbing the relative positions
 of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
 and you want to check one by one to see if T has its subsequence.
 In this scenario, how would you change your code?

 */
public class N392_IsSubsequence {
    // Pinterest
    // 18 ms 13 / 13 test cases passed.
    // two pointers.
    public class Solution {
        public boolean isSubsequence(String s, String t) {
            int i=0, j=0;
            char[] a = s.toCharArray(), b = t.toCharArray();
            while(i<a.length && j < b.length){
                if(a[i] == b[j]) i++;
                j++;
            }
            return i == a.length;
        }
    }
    // follow up solution
    // put all t chars in  map<char, list of index for this char>
    // for each char in s, to see if we could find an index in t for that char is larger than t_pre_index.
    // 14 / 14 test cases passed.
    // 100 ms
    public class Solution_followup_large_t {
        public boolean isSubsequence(String s, String t) {
            if (s == null || t == null) return false;

            Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>

            //preprocess t
            for (int i = 0; i < t.length(); i++) {
                char curr = t.charAt(i);
                if (!map.containsKey(curr)) {
                    map.put(curr, new ArrayList<Integer>());
                }
                map.get(curr).add(i);
            }

            int prev = -1;  //index of previous character
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (map.get(c) == null)  {
                    return false;
                } else {
                    List<Integer> list = map.get(c);
                    prev = binarySearch(prev, list, 0, list.size() - 1);
                    if (prev == -1) {
                        return false;
                    }
                    prev++;
                }
            }

            return true;
        }

        // find the index >= prev
        private int binarySearch(int index, List<Integer> list, int start, int end) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (list.get(mid) < index) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return start == list.size() ? -1 : list.get(start);
        }
    }
}
