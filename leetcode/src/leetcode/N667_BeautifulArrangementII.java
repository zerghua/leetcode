package leetcode;

import java.util.ArrayList;

/**
 * Created by HuaZ on 8/27/2017.

 Given two integers n and k, you need to construct a list which contains n different positive integers
 ranging from 1 to n and obeys the following requirement:
 Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|]
 has exactly k distinct integers.

 If there are multiple answers, print any of them.

 Example 1:

 Input: n = 3, k = 1
 Output: [1, 2, 3]
 Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3,
 and the [1, 1] has exactly 1 distinct integer: 1.

 Example 2:

 Input: n = 3, k = 2
 Output: [1, 3, 2]
 Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3,
 and the [2, 1] has exactly 2 distinct integers: 1 and 2.

 Note:

 The n and k are in the range 1 <= k < n <= 104.


 1, k+1, 2, k, 3, k-1 ...;
 The distance of this sequence is k, k-1, k-2, ..., 2, 1

 max valid k = n-1

 example:
 n = 9,

 k = 5, l = 1; r = 6; while(l < = r)
 1 6 2 5 3 4 7 8 9
  5 4 3 2 1 3 1 1



 k = 7, l = 1; r = 8; while(l < = r)
1 8 2 7 3 6 4 5 9
 7 6 5 4 3 2 1 4
 */



public class N667_BeautifulArrangementII {
    // reorder array
    // number 1-n. if ascending order, always has diff = 1.
    // reorder to be 1, k+1, 2, k, 3 ... so have diff = k,k-1,k-2....1
    // 68 / 68 test cases passed.
    // 13 ms
    class Solution {
        public int[] constructArray(int n, int k) {
            int l = 1, r = k + 1;
            ArrayList<Integer> ret = new ArrayList();
            while(l <= r){
                ret.add(l++);
                if(l <= r) ret.add(r--);
            }

            for(int i=k+2;i<=n;i++){
                ret.add(i);
            }

            int[] ans = new int[n];
            for(int i=0;i<n;i++) ans[i] = ret.get(i);
            return ans;
        }
    }
}
