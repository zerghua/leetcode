package leetcode;

/**
 * Created by HuaZ on 9/4/2017.

 Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 Return the maximum valued number you could get.

 Example 1:

 Input: 2736
 Output: 7236
 Explanation: Swap the number 2 and the number 7.

 Example 2:

 Input: 9973
 Output: 9973
 Explanation: No swap.

 Note:

 The given number is in the range [0, 10^8]


 */
public class N670_MaximumSwap {
    // 111 / 111 test cases passed.
    // 9 ms
    // array swap with some corner cases.
    class Solution {
        public int maximumSwap(int num) {
            char[] s = Integer.toString(num).toCharArray();
            int n = s.length;
            for(int i=0; i<n;i++){
                int k = i+1;
                // find max index
                for(int j=i+1; j<n;j++){
                    if(s[j] >= s[k]) k = j;  // >= is important for case 19935 -> 99135 rather than 91934
                }
                if(k< n && s[k] > s[i]) {
                    swap(s, k, i);
                    break;
                }
            }
            return Integer.parseInt(new String(s));
        }

        public void swap(char[] s, int i, int j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

}
