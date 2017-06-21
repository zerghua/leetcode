package leetcode;

/**
 * Created by Hua on 6/21/2017.

 Given a positive integer n, find the number of non-negative integers less than or equal to n,
 whose binary representations do NOT contain consecutive ones.

 Example 1:

 Input: 5
 Output: 5
 Explanation:
 Here are the non-negative integers <= 5 with their corresponding binary representations:
 0 : 0
 1 : 1
 2 : 10
 3 : 11
 4 : 100
 5 : 101
 Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.

 Note: 1 <= n <= 10^9



 This problem can be solved using Dynamic Programming.
 Let a[i] be the number of binary strings of length i which do not contain any two consecutive 1’s and which end in 0.
 Similarly, let b[i] be the number of such strings which end in 1. We can append either 0 or 1 to a string ending in 0,
 but we can only append 0 to a string ending in 1. This yields the recurrence relation:

 a[i] = a[i - 1] + b[i - 1]
 b[i] = a[i - 1]


 The base cases of above recurrence are a[1] = b[1] = 1. The total number of strings of length i is just a[i] + b[i].

 Following is the implementation of above solution. In the following implementation, indexes start from 0.
 So a[i] represents the number of binary strings for input length i+1. Similarly, b[i] represents binary strings
 for input length i+1.


 First, we need to do the subtraction only for the highest effective bit as the problem requires less than or equal to n.

 Second, when there are two consecutive ones, other integers will be less than it, stop!

 Third, if we met 01, according to the dp formula, the number of qualified integers for first 0 should be 00 and 01,
 both of them are less than or equal to 01. The same for 10.

 Finally, for 00, the number of qualified integers for first 0 should be 00 and 01,
 but 01 is greater than 00, we should subtract it.


 */
public class N600_NonnegativeIntegerswithoutConsecutiveOnes {
    // DP + math
    // 527 / 527 test cases passed.
    // 39 ms
    public class Solution {
        public int findIntegers(int num) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();  // reverse is important
            int n = sb.length();
            int[] a = new int[n], b = new int[n];
            a[0] = b[0] = 1;
            for(int i=1; i<n; i++){
                a[i] = a[i-1] + b[i-1];   // a[i] means end with 0
                b[i] = a[i-1];            // b[i] means end with 1
            }

            int ret = a[n-1] + b[n-1];

            for(int i=n-2; i>=0; i--){
                if(sb.charAt(i) == '1' && sb.charAt(i+1) == '1') break;
                if(sb.charAt(i) == '0' && sb.charAt(i+1) == '0') ret -= b[i];
            }

            return ret;
        }
    }

}
