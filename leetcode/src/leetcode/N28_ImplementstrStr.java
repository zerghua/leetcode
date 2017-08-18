package leetcode;
/*

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

version 2 and 3 adds on 9/1/2016
*/
public class N28_ImplementstrStr {
    // Microsoft, Facebook, Google.
    // o(n*m) brute force
    // 74 / 74 test cases passed.  on 8/18/2017
    // 8 ms
    public class Solution {
        public int strStr(String haystack, String needle) {
            if(haystack==null || needle ==null) return -1;
            if(needle.length()==0 ) return 0;
            if(haystack.length()==0 ) return -1;
            int i=0, j=0;
            char[] t = haystack.toCharArray();
            char[] p = needle.toCharArray();
            while(i<t.length && j<p.length){
                if(t[i] == p[j]){
                    i++;
                    j++;
                }else{
                    i = i-j+1;
                    j = 0;
                }
            }
            int ret = -1;
            if(j==p.length) ret = i-j;
            return ret;
        }
    }



    // added on 10/4/2016  very concise solution
    // 18 ms  72 / 72 test cases passed.
    public class Solution2 {
        public int strStr(String haystack, String needle) {
            for(int i=0; ;i++){
                for(int j=0; ;j++){
                    if(j == needle.length()) return i;
                    if(i+j == haystack.length()) return -1;
                    if(haystack.charAt(i+j) != needle.charAt(j))break;
                }
            }
        }
    }



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






    // String match KMP
    public int strStr3(String haystack, String needle) {
        if(haystack==null || needle ==null) return -1;
        if(needle.length()==0 ) return 0;
        if(haystack.length()==0 ) return -1;
        int i=0, j=0;
        char[] t = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[] next = getNext(p);
        while(i<t.length && j<p.length){
            if(j==-1 || t[i] == p[j]){
                i++;j++;
            }else j = next[j];
        }
        int ret= -1;
        if(j==p.length) ret = i-j;
        return ret;
    }

    // 4 ms  72 / 72 test cases passed.
    // next[j] == k    and   k=next[k] recursive
    public int[] getNext(char[] p){
        int[] next = new int[p.length];
        next[0] = -1;
        int j=0, k=-1;
        while(j<p.length-1){   // length -1
            if(k == -1 || p[j] == p[k]) {
                j++;k++;
                next[j] = k;
            }
            else k = next[k];
        }
        return next;
    }

    // 5 ms
    public int[] getNext2(char[] p){
        int[] next = new int[p.length];
        next[0] = -1;
        int j=0, k=-1;
        while(j<p.length-1){   // length -1
            if(k == -1 || p[j] == p[k]) {
                j++;k++;
                if(p[j] == p[k]) next[j] = next[k];  // optimize for case like "abab"
                else next[j] = k;
            }
            else k = next[k];
        }
        return next;
    }


    
}
