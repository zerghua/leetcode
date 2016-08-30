package leetcode;

/*
	Write a function to find the longest common prefix string amongst an array of strings.

 */


public class N14_LongestCommonPrefix {
	// 2 ms
	// vertical scanning of each string. o(s), s is sum of all the strings
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0) return "";
        int min_size=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++) {
        	if(strs[i].length()<min_size) min_size = strs[i].length();
        }
    	if(min_size == 0 ) return "";
    	String ret="";
    	boolean not_euqal_found=false;
        for(int i=0; i<min_size;i++){
        	char c = strs[0].charAt(i);
        	for(int j=1;j<strs.length;j++){
        		if(strs[j].charAt(i) != c) {
        			not_euqal_found=true;
        			break;
        		}
        	}
        	if (not_euqal_found) break;
        	else ret += c;
        }
        return ret;
    }
}
