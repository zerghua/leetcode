package leetcode;

/**
 * Created by HuaZ on 10/20/2016.

 Given a positive integer n and you can do operations as follow:

 If n is even, replace n with n/2.
 If n is odd, you can replace n with either n + 1 or n - 1.

 What is the minimum number of replacements needed for n to become 1?

 Example 1:

 Input:
 8

 Output:
 3

 Explanation:
 8 -> 4 -> 2 -> 1

 Example 2:

 Input:
 7

 Output:
 4

 Explanation:
 7 -> 8 -> 4 -> 2 -> 1
 or
 7 -> 6 -> 3 -> 2 -> 1


 https://discuss.leetcode.com/topic/58334/a-couple-of-java-solutions-with-explanations/2

 */
public class N397_IntegerReplacement {
    // the way to think about this problem is to decide which way to go:
    // 1. even number, divide 2
    // 2. odd number +1, when last two binary digit is 11,  exception 3,  should -1
    // 3. odd number -1, when last two binary digit is 01
    // corner case, Integer.MAX_VALUE + 1 will overflow to negative. how to handle?
    // >>> is unsigned-shift; it'll insert 0. >> is signed, and will extend the sign bit.

    public class Solution {
        // 5 ms 47 / 47 test cases passed.
        public int integerReplacement(int n) {
            int ret = 0;
            while(n != 1){
                if( (n & 1) == 0) n >>>= 1; //even, divide 2, important to use >>> here to handle overflowed n
                else if(n == 3 || ((n >>> 1) & 1) == 0) n--;
                else n++;
                ret++;
            }
            return ret;
        }
    }

    public static void main(String[] args){
        int[] a = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE+1, 1, -1, -5};
        for(int i=0;i<a.length;i++){
            System.out.println(Integer.toBinaryString(a[i]) + " " + a[i]);
        }

    }

}
