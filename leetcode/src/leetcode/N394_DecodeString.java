package leetcode;

/**
 * Created by HuaZ on 10/20/2016.

 Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string
 inside the square brackets is being repeated exactly k times.
 Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces,
 square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits
 and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".


 */
public class N394_DecodeString {
    // Google
    // 3 ms 26 / 26 test cases passed.
    // DFS
    public class Solution {
        int i=0;
        public String decodeString(String s) {
            return dfs(s, 0);
        }
        public String dfs(String s, int start){
            if(start >= s.length()) return "";
            StringBuilder ret = new StringBuilder();
            int num = 0;
            for(i=start; i<s.length(); i++){
                char c= s.charAt(i);
                if(Character.isLetter(c)) ret.append(c);
                else if(Character.isDigit(c)) num = num*10 + c-'0';
                else if(c == '['){
                    String insideStr = dfs(s, i+1);
                    for(int j=0;j<num;j++) ret.append(insideStr);
                    num = 0;
                }else if(c == ']') return ret.toString();
                else throw new IllegalArgumentException("Invalid input");
            }
            return ret.toString();
        }
    }
}
