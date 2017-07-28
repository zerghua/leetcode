package leetcode;

/**
 * Created by Hua on 7/10/2017.

 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic

 */

import java.util.*;
public class N246_StrobogrammaticNumber {
    // google
    // 47 / 47 test cases passed.
    // 1 ms
    public class Solution {
        // similar to palindrome checking but more conditions
        public boolean isStrobogrammatic(String num) {
            HashSet<Integer> set = new HashSet(Arrays.asList(new Integer[]{0, 1, 8}));  // can't use new int[]
            int i=0, j = num.length()-1;
            while(i <= j){
                int a = num.charAt(i) - '0', b = num.charAt(j) - '0';
                i++; j--;
                if((a == 6 && b == 9) || (a == 9 && b == 6)) continue;
                if(a != b || !set.contains(a)) return false;
            }
            return true;
        }
    }

    // shorter solution
    // 47 / 47 test cases passed.
    // 1 ms
    public class Solution2 {
        public boolean isStrobogrammatic(String num) {
            for (int i=0, j=num.length()-1; i <= j; i++, j--)
                if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
                    return false;
            return true;
        }
    }


}
