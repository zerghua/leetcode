package leetcode;

import java.util.HashMap;

/**
 * Created by HuaZ on 10/11/2016.

 This is a problem asked by Google.

 The following solution is corrected. Given "abcadcacacaca" and 3, it returns "cadcacacaca".
 */
public class N340_LongestSubstringwithAtMostKDistinctCharacters {
    // sliding window, similar to N159.
    public class Solution{
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if(s == null || k<=0) return 0;
            if(s.length()<=k) return s.length();

            HashMap<Character, Integer> map = new HashMap();
            int ret = 0, left = 0;
            char[] str = s.toCharArray();
            for(int i=0; i<str.length; i++){
                map.put(str[i], 1+map.getOrDefault(str[i], 0));
                if(map.size() > k){
                    while(map.size()>k){
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

    // assume all ascii chars.
    public class Solution2{
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if(s == null || k<=0) return 0;
            if(s.length()<=k) return s.length();

            int[] map = new int[256];
            int ret = 0, left = 0, size=0;
            char[] str = s.toCharArray();
            for(int i=0; i<str.length; i++){
                if(map[str[i]] == 0) size++;
                map[str[i]]++;
                if(size > k){
                    while(size>k){
                        map[str[left]]--;
                        if(map[str[left]]==0) size--;
                        left++;
                    }
                }
                ret = Math.max(ret, i-left+1);  //windows only contains at most k unique chars.
            }
            return ret;
        }
    }

    public static void main(String[] args){
        N340_LongestSubstringwithAtMostKDistinctCharacters.Solution x=
                new N340_LongestSubstringwithAtMostKDistinctCharacters().new Solution();
        System.out.println(x.lengthOfLongestSubstringKDistinct("abcadcacacaca",3));

        N340_LongestSubstringwithAtMostKDistinctCharacters.Solution2 x2=
                new N340_LongestSubstringwithAtMostKDistinctCharacters().new Solution2();
        System.out.println(x2.lengthOfLongestSubstringKDistinct("abcadcacacaca",3));



    }
}
