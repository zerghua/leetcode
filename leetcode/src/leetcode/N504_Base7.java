package leetcode;

/**
 * Created by Hua on 5/11/2017.

 Given an integer, return its base 7 string representation.

 Example 1:

 Input: 100
 Output: "202"

 Example 2:

 Input: -7
 Output: "-10"

 Note: The input will be in range of [-1e7, 1e7].

 */
public class N504_Base7 {
    // no company
    // cool recursion
    // 241 / 241 test cases passed.
    // 18 ms
    public class Solution {
        public String convertToBase7(int num) {
            if(num < 0) return "-" + convertToBase7(-num);
            if(num < 7) return "" + num;
            return convertToBase7(num/7) + num%7;
        }
    }
}
