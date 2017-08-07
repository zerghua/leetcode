package leetcode;
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5.

 */
public class N58_LengthofLastWord {
	// no company
    //0 ms
    public int lengthOfLastWord(String s) {
        if(s.length() ==0 || s==null) return 0;
        
        int len=0;
        for(int i=s.length()-1; i>=0;i--){
        	if(s.charAt(i)== ' ') {
        		if(len == 0) continue;
        		else break;   	
        	}
        	len++;
        }
        return len;
    }

    // version 2 added on 9/7/2016
    // 0 ms  59 / 59 test cases passed.
    // String operation. scan from last. o(n)
    public class Solution {
        public int lengthOfLastWord(String s) {
            if(s.length() ==0 || s==null) return 0;
            int ret=0;
            for(int i=s.length()-1; i>=0;i--){
                if(s.charAt(i) != ' ') ret++;
                else {
                    if(ret != 0) break;  // trailing spaces.
                }
            }
            return ret;
        }
    }

}
