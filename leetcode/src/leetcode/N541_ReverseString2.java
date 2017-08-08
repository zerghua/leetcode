package leetcode;

/**
 * Created by Hua on 5/5/2017.


 Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from
 the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k
 but greater than or equal to k characters, then reverse the first k characters and left the other as original.

 Example:

 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"

 Restrictions:

 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]

 */
public class N541_ReverseString2 {
    // Google
    // String
    // 60 / 60 test cases passed.
    // 6 ms
    public class Solution {
        public String reverseStr(String s, int k) {
            int n = s.length(), i = 0;
            char[] c = s.toCharArray();
            while(i < n){
                int j = Math.min(i + k - 1, n -1);
                swap(i, j, c);
                i += 2*k;
            }
            return String.valueOf(c);
        }

        public void swap(int i, int j, char[] c){
            while(i<j){
                char tmp = c[i];
                c[i] = c[j];
                c[j] = tmp;
                i++; j--;
            }
        }
    }
}
