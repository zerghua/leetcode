package leetcode;

/*
Write a function to find the longest common prefix string amongst an array of strings.

second version added on 8/30/2016
*/


public class N14_LongestCommonPrefix {
    // yelp
	// shorter code than previous version, the same idea
	// 3 ms
	public String longestCommonPrefix2(String[] strs) {
		if(strs == null || strs.length == 0) return "";
		for(int i=0;i<strs[0].length();i++){
			char c = strs[0].charAt(i);
			for(int j=1;j< strs.length; j++){
				if(i>= strs[j].length() || strs[j].charAt(i) != c) return strs[0].substring(0,i);
			}
		}
		return strs[0];
	}

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
