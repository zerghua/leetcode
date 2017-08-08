package leetcode;

/**
 * Created by Hua on 7/10/2017.

 Given a string s, return all the palindromic permutations (without duplicates) of it.
 Return an empty list if no palindromic permutation could be form.

 For example:

 Given s = "aabb", return ["abba", "baab"].

 Given s = "abc", return [].

 */

import java.util.*;
public class N267_PalindromePermutationII {
    // no company
    // 29 / 29 test cases passed.
    // 4 ms
    // 1. check isPal of this string
    // 2. permute first half to build string
    public class Solution {
        public List<String> generatePalindromes(String s) {
            List<String> ret = new LinkedList();
            int[] map = new int[256];
            int count = 0;
            for(char c: s.toCharArray()){
                map[c]++;
                count = map[c] % 2 == 1 ? count + 1 : count - 1;
            }
            if(count > 1) return ret;

            int length = 0;  // length of half string without mid
            String mid = "";
            for(int i=0; i<256; i++){
                if(map[i] % 2 == 1) mid = "" + (char)i;
                map[i] /= 2;
                length += map[i];
            }

            dfs(map, ret, "", length, mid);
            return ret;
        }

        public void dfs(int[] map, List<String> ret, String s, int length, String mid){
            if(s.length() == length){
                String reverse = new StringBuilder(s).reverse().toString();
                ret.add(s + mid + reverse);
                return;
            }

            for(int i=0; i<256; i++){  // very smart to avoid duplicate
                if(map[i] > 0){
                    map[i]--;
                    dfs(map, ret, s + (char)i, length, mid);
                    map[i]++;
                }
            }
        }
    }
}
