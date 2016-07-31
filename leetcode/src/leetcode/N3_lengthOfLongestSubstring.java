package leetcode;
import java.util.HashMap;

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
    
}
