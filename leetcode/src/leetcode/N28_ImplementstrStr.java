package leetcode;

public class N28_ImplementstrStr {
	//5 ms
    public int strStr(String haystack, String needle) {   
        if(haystack==null || needle ==null) return -1;
        if(needle.length()==0 ) return 0;
    	if(haystack.length()==0 ) return -1;
    	
    	int ret_index = -1;
    	for(int i=0;i<haystack.length() - needle.length() + 1; i++){
    		// the first char is equal, check if the whole needle match
    		if(haystack.charAt(i) == needle.charAt(0)){
    			boolean all_match=true;
    			for(int j=1;j<needle.length();j++){
    				if(haystack.charAt(i+j) != needle.charAt(j)) {
    					all_match = false;
    					break;
    				}
    			}
    			if(all_match) {
    				ret_index = i;
    				break;
    			}
    		}
        }
    	return ret_index;
    }
    
    
    //kmp
    
    
    
}
