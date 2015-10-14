package leetcode;
import java.util.HashMap;

public class N3_lengthOfLongestSubstring {
	//425ms 38%
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
