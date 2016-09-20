package leetcode;
import java.util.*;
/*

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

 */
public class N205_IsomorphicStrings {
	//38 ms
    // test case:  aa and ab.
	public boolean isIsomorphic(String s, String t){
		return isIsomorphic_helper(s,t) && isIsomorphic_helper(t,s);
	} 
	
    public static boolean isIsomorphic_helper(String s, String t) {
        int len = s.length();
    	if(s ==null || len==0) return true;
    	
    	HashMap<Character, Character> hm = new HashMap<Character, Character>();
        for(int i=0; i<len; i++){
        	char key = s.charAt(i);
        	char value = t.charAt(i);
        	if(hm.containsKey(key) && hm.get(key) != value) return false;
        	hm.put(key, value);
        }
    	return true;
    }
    
    public static void main(String[] args){
    	String s="paper", t="title";
    	System.out.println(isIsomorphic_helper(s,t));
    	System.out.println(isIsomorphic_helper(t,s));
    }

    // solution 2,3,4 added on 9/20/2016
    // two way hashmap
    // 31 ms 30 / 30 test cases passed.
    public class Solution2 {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
            for(Integer i=0;i<s.length();i++){ // important Integer object not int to guarantee unique object
                if( m1.put(s.charAt(i), i) != m2.put(t.charAt(i),i)) return false;
            }
            return true;
        }
    }

    // a little bit optimization  28 ms
    public class Solution3 {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
            char[] c1 = s.toCharArray(), c2 =t.toCharArray();
            for(Integer i=0;i<s.length();i++){ // important Integer object not int to guarantee unique object
                if( m1.put(c1[i], i) != m2.put(c2[i],i)) return false;
            }
            return true;
        }
    }

    // 5 ms
    public class Solution4 {
        public boolean isIsomorphic(String s, String t) {
            int[] m1 = new int[128], m2 = new int[128];
            char[] c1 = s.toCharArray(), c2 =t.toCharArray();
            for(int i=0;i<s.length();i++){
                if( m1[c1[i]] != m2[c2[i]] ) return false;
                else if(m1[c1[i]] == 0) m1[c1[i]] = m2[c2[i]] = i+1;
            }
            return true;
        }
    }


}
