package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/14/2016.

 This is a problem asked by Google.

 Given a string, find the longest substring that contains only two unique characters.
 For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character
 is "bcbbbbcccb".

 */
public class N159_LongestSubstringwithAtMostTwoDistinctCharacters {
    // google
    // sliding window only contains at most 2 unique chars with the help of hashmap.
    // 125 / 125 test cases passed.
    // 32 ms
    public class Solution{
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            HashMap<Character, Integer> map = new HashMap();
            int ret = 0, left = 0;
            char[] str = s.toCharArray();
            for(int i=0; i<str.length; i++){
                map.put(str[i], 1+map.getOrDefault(str[i], 0));
                if(map.size() > 2){
                    while(map.size()>2){
                        map.put(str[left], map.get(str[left])-1);
                        if(map.get(str[left])==0) map.remove(str[left]);
                        left++;
                    }
                }
                ret = Math.max(ret, i-left+1);  //windows only contains at most 2 unique chars.
            }
            return ret;
        }
    }

    // assume it's all ascii chars. use int[256] than hashmap, and extra variable to store unique char size.
    // 125 / 125 test cases passed.
    // 5 ms
    public class Solution2{
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int[] map = new int[256];
            int ret = 0, left = 0, size=0;
            char[] str = s.toCharArray();
            for(int i=0; i<str.length; i++){
                if(map[str[i]] == 0) size++;
                map[str[i]]++;
                if(size > 2){
                    while(size>2){
                        map[str[left]]--;
                        if(map[str[left]]==0) size--;
                        left++;
                    }
                }
                ret = Math.max(ret, i-left+1);  //windows only contains at most 2 unique chars.
            }
            return ret;
        }
    }


    // sliding window
    // on 7/24/2017
    // 125 / 125 test cases passed.
    // 52 ms
    public class Solution3 {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int ret = 0, left = 0;
            HashMap<Character, Integer> map = new HashMap();
            for(int i=0; i<s.length(); i++){
                char key = s.charAt(i);
                if(!map.containsKey(key)) map.put(key, 0);
                map.put(key, map.get(key) + 1);
                while(map.size() > 2){
                    char c = s.charAt(left);
                    map.put(c, map.get(c) - 1);
                    if(map.get(c) == 0) map.remove(c);
                    left++;
                }
                ret = Math.max(ret, i - left + 1);
            }
            return ret;
        }
    }

    public static void main(String[] args){
        N159_LongestSubstringwithAtMostTwoDistinctCharacters.Solution x=
                new N159_LongestSubstringwithAtMostTwoDistinctCharacters().new Solution();
        System.out.println(x.lengthOfLongestSubstringTwoDistinct("abcbbbbcccbdddadacb"));

        N159_LongestSubstringwithAtMostTwoDistinctCharacters.Solution2 x2=
                new N159_LongestSubstringwithAtMostTwoDistinctCharacters().new Solution2();
        System.out.println(x2.lengthOfLongestSubstringTwoDistinct("abcbbbbcccbdddadacb"));



    }
}
