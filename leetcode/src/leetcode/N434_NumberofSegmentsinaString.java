package leetcode;

/**
 * Created by HuaZ on 12/4/2016.

 Count the number of segments in a string, where a segment is defined to be a contiguous
 sequence of non-space characters.

 Please note that the string does not contain any non-printable characters.

 Example:

 Input: "Hello, my name is John"
 Output: 5


 */
public class N434_NumberofSegmentsinaString {
    // state machine
    // https://en.wikipedia.org/wiki/Finite-state_machine
    // 3 ms 26 / 26 test cases passed.
    public class Solution {
        public int countSegments(String s) {
            int ret=0, state=1;
            for(char c: s.toCharArray()){
                if(c == ' ') state = 1;
                else if(state == 1){
                    ret++;
                    state = 0;
                }
            }
            return ret;
        }
    }
}
