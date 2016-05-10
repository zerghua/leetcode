package leetcode;
import java.util.HashMap;

/**
 * Created by Hua on 5/9/2016.
 *
 *  Given a string S and a string T,
 *  find the minimum window in S which will contain
 *  all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"

 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T,
 return the empty string "".

 If there are multiple such windows, you are guaranteed that
 there will always be only one unique minimum window in S.
 */
public class N76_MinimumWindowSubstring {
    // 44 ms
    // hash table and two pointers
    // hash table to store chars in t
    // one pointer to go through s
    // one pointer to left char of the window and update properly
    public String minWindow(String s, String t) {
        if(s==null || s.length() ==0) return "";

        // populate hashmap with chars in t
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }

        int left = 0, right=0; // two pointers
        int min_len = Integer.MAX_VALUE, min_start = 0;
        int count = 0; // count number of valid chars in s
        for(right=0; right < s.length(); right++){
            // story only happens when there is a char in s exists in t.
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c) >=0) count++; //reduce count only when it's needed in t

                // move left window to it's min length
                while(count == t.length()){

                    //update min length
                    if(right-left+1 < min_len) {
                        min_len = right - left + 1;
                        min_start = left;
                    }

                    // decide if window moving should stop
                    // to solve  s="aabc"  t = "ab", end of while, left = 2
                    char left_char = s.charAt(left);
                    if(map.containsKey(left_char)){
                        map.put(left_char, map.get(left_char)+1);
                        if(map.get(left_char) > 0) count--;
                    }
                    left++;
                }
            }
        }

        if(min_len > s.length()) return "";
        return s.substring(min_start, min_start+min_len);
    }

}


