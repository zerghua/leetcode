package leetcode;

/**
 * Created by Hua on 7/10/2017.

 Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.

 */

import java.util.*;
public class N266_PalindromePermutation {
    // easy hashmap
    // 26 / 26 test cases passed.
    // 4 ms
    public class Solution {
        public boolean canPermutePalindrome(String s) {
            HashMap<Character, Integer> map = new HashMap();
            for(char c : s.toCharArray()){
                if(!map.containsKey(c)) map.put(c, 1);
                else map.put(c, map.get(c) + 1);
            }
            int count = 0;
            for(char c: map.keySet()){
                if(map.get(c) % 2 == 1) count++;
            }
            return count <= 1;
        }
    }
}
