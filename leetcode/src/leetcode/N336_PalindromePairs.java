package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 8/13/2016.

 Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list,
 so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]

 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

 */
public class N336_PalindromePairs {
    // Google, Airbnb
    // hashtable and divide and conquer
    // 134 / 134 test cases passed.  on 8/26/2017
    // 147 ms
    public class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            HashSet<List<Integer>> ret = new HashSet<List<Integer>>();
            if(words == null || words.length ==0) return null;
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0;i<words.length;i++) map.put(words[i],i);

            for(int i=0;i<words.length;i++){            // for each word
                for(int j=0;j<=words[i].length();j++){  // divide each word to two string
                    String str1 = words[i].substring(0,j);
                    String str2 = words[i].substring(j);
                    if(isPalindrome(str1)){
                        String reverseStr = new StringBuilder(str2).reverse().toString();
                        if(map.containsKey(reverseStr) && map.get(reverseStr) != i){
                            ret.add(Arrays.asList(map.get(reverseStr),i));
                        }
                    }

                    if(isPalindrome(str2)){
                        String reverseStr = new StringBuilder(str1).reverse().toString();
                        if(map.containsKey(reverseStr) && map.get(reverseStr) != i){
                            ret.add(Arrays.asList(i,map.get(reverseStr)));
                        }
                    }
                }
            }
            return new ArrayList<List<Integer>>(ret); // to get rid of duplicate
        }

        public boolean isPalindrome(String s){
            int left =0, right=s.length()-1;
            while(left<=right){
                if(s.charAt(left++) != s.charAt(right--)) return false;
            }
            return true;
        }
    }
}
