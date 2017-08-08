package leetcode;

import java.util.*;

/**
 * Created by Hua on 5/3/2017.

 Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits
 existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists,
 you need to return -1.

 Example 1:
 Input: 12
 Output: 21


 Example 2:
 Input: 21
 Output: -1


 */
public class N556_NextGreaterElement3 {
    // Bloomberg
    // From right to left, the idea is to find the number greater than num[i], swap it,
    // and sort the rest of the elements to the right.
    // tricky math
    // 34 / 34 test cases passed.
    // 4 ms
    public class Solution {
        public int nextGreaterElement(int n) {
            char[] s = (n + "").toCharArray();
            for(int i=s.length-2; i>=0; i--){
                int min_index = i;

                // get smallest after i, because the right one is always smaller than left ones.
                for(int j = i+1; j<s.length; j++){
                    if(s[i] < s[j]) min_index = j;
                }

                if(i != min_index){
                    char tmp = s[i];
                    s[i] = s[min_index];
                    s[min_index] = tmp;

                    Arrays.sort(s, i+1, s.length); // sort right after i
                    long ret = Long.valueOf(new String(s));
                    return (ret <= Integer.MAX_VALUE)? (int) ret : -1;
                }
            }
            return -1;
        }
    }
}
