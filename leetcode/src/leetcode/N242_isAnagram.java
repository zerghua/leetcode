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


    // solution 2 added on 9/22/2016
    // 4 ms  34 / 34 test cases passed.
	public class Solution {
		public boolean isAnagram(String s, String t) {
            if(s.length() != t.length() ) return false;
            int[] count = new int[128]; // only lower case alphabets

            char[] s_array= s.toCharArray(), t_array=t.toCharArray();
            for(int i=0;i<s.length();i++) count[s_array[i]]++;
            for(int i=0;i<t.length();i++) {
                count[t_array[i]]--;
                if(count[t_array[i]] < 0) return false;
            }
            return true;
		}
	}

    // concise code added on 10/27/2016
    // 4 ms  34 / 34 test cases passed.
    public class Solution3 {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length() ) return false;
            int[] map = new int[128]; // only lower case alphabets
            for(char c: s.toCharArray()) map[c]++;
            for(char c: t.toCharArray()) {
                if(--map[c] < 0) return false;
            }
            return true;
        }
    }

}
