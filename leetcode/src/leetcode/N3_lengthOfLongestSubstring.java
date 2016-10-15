package leetcode;
import java.util.HashMap;
import java.util.stream.Collector;

/*
    Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3.
    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class N3_lengthOfLongestSubstring {
	//425ms 38%
    // sliding window, o(n)
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int lastIndex=-1;
        HashMap<Character, Integer>  hm = new HashMap<Character, Integer>();
        
        for(int i=0;i<s.length(); i++){
        	if(hm.containsKey(s.charAt(i)) && lastIndex < hm.get(s.charAt(i))){
        		lastIndex = hm.get(s.charAt(i));
        	}
        	
        	if(i - lastIndex > max) max = i-lastIndex;
        	
        	hm.put(s.charAt(i), i);
        }
        return max;
    }
    
    //not using hashmap, but custom map   400ms 69%
    public int lengthOfLongestSubstring2(String s) {
        int max=0;
        int lastIndex=-1;
        int size=256;
        int[] hm = new int[size];
        for(int i=0;i<size;i++) hm[i]=-1;
        
        for(int i=0;i<s.length(); i++){
        	if(hm[s.charAt(i)] != -1 && lastIndex < hm[s.charAt(i)] ){
        		lastIndex = hm[s.charAt(i)];
        	}
        	
        	if(i - lastIndex > max) max = i-lastIndex;
        	
        	hm[s.charAt(i)] =i;
        }
        return max;
    }


    // solution 3 added on 9/27/2016
    // sliding windows with two pointers, hashtable to store index of previous duplicate num[i]
    // 40 ms 982 / 982 test cases passed.
    // example: abcdbcdef
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] map = new int[256];
            for(int i=0;i<256;i++) map[i] = -1;

            char[] str = s.toCharArray();
            int left = -1, max = 0;
            for(int i=0;i<str.length;i++){
                if(map[str[i]] != -1) left = Math.max(left, map[str[i]]);
                max = Math.max(max, i-left);
                map[str[i]] = i;
            }
            return max;
        }
    }

    // added on 9/29/2016
    // 80 ms 982 / 982 test cases passed.
    public class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            int ret=0, left=-1;           //importatnt left=-1
            HashMap<Character, Integer> map = new HashMap<>();
            char[] ch = s.toCharArray();
            for(int i=0;i<ch.length;i++){
                if(map.containsKey(ch[i])) left = Math.max(left, map.get(ch[i])); // important max
                ret = Math.max(ret, i-left);
                map.put(ch[i], i);
            }
            return ret;
        }
    }

    // more intuitive solution. added on 10/12/2016
    // 56 ms 982 / 982 test cases passed.
    public class Solution4 {
        public int lengthOfLongestSubstring(String s) {
            int ret=0, left=0;
            HashMap<Character, Integer> map = new HashMap<>();
            char[] ch = s.toCharArray();
            for(int i=0;i<ch.length;i++){
                if(map.containsKey(ch[i])) left = Math.max(left, map.get(ch[i])); // important max
                ret = Math.max(ret, i-left+1); // window only contains unique chars.
                map.put(ch[i], i+1);
            }
            return ret;
        }
    }

    public static void main(String[] args){
        N3_lengthOfLongestSubstring.Solution x = new N3_lengthOfLongestSubstring().new Solution();
        System.out.println(x.lengthOfLongestSubstring("aab"));
    }
}
