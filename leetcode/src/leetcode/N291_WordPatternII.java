package leetcode;

/**
 * Created by Hua on 7/26/2017.

 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match,
 such that there is a bijection between a letter in pattern and a non-empty substring in str.


 Examples:

 pattern = "abab", str = "redblueredblue" should return true.
 pattern = "aaaa", str = "asdasdasdasd" should return true.
 pattern = "aabb", str = "xyzabcxzyabc" should return false.

 Notes:
 You may assume both pattern and str contains only lowercase letters.


 */

import java.util.*;
public class N291_WordPatternII {
    // uber, dropbox (Premium)
    // fair complex backtracking.
    // 22 / 22 test cases passed.
    // 116 ms
    public class Solution {
        public boolean wordPatternMatch(String pattern, String str) {
            HashMap<Character, String> map = new HashMap();
            HashSet<String> set = new HashSet();
            return dfs(pattern, 0, str, 0, map, set);
        }

        public boolean dfs(String pattern, int i, String str, int j, HashMap<Character, String> map, HashSet<String> set){
            if(i == pattern.length() && j == str.length()) return true;
            if(i == pattern.length() || j == str.length()) return false;

            char c = pattern.charAt(i);

            if(map.containsKey(c)){    // try to match as much as possible
                String s = map.get(c);
                if(!str.startsWith(s, j)) return false; //early return
                return dfs(pattern, i+1, str, j + s.length(), map, set);  // matched, check substring
            }

            for(int k = j; k< str.length(); k++){  // try each substring in str to match pattern c
                String s = str.substring(j, k+1);
                if(set.contains(s)) continue;      // bijection requirement

                map.put(c, s);
                set.add(s);

                if(dfs(pattern, i+1, str, j + s.length(), map, set)) return true;

                map.remove(c);
                set.remove(s);
            }

            return false;
        }
    }
}
