package leetcode;
import java.util.*;

public class N205_IsomorphicStrings {
	//38 ms
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
}
