package leetcode;
/*

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */

public class N242_isAnagram {
	
	// 324 ms 73%
    public boolean isAnagram(String s, String t) {
    	if(s.length() != t.length() ) return false;
    	else {
	    	int size = 'z' - 'a' + 1 ;
	    	int string_len = s.length();
	        int[] c = new int[size];
	        
	        for(int i=0;i<string_len;i++) c[s.charAt(i) - 'a']++ ;
	        for(int i=0;i<string_len;i++) c[t.charAt(i) - 'a']-- ;
	        
	        for(int i=0;i<size;i++){
	        	if(c[i] !=0) return false;
	        }         
	    	return true;
    	}
    }
}
