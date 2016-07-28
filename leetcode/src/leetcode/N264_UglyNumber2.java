package leetcode;

import java.util.ArrayList;

/**
 * Created by HuaZ on 7/27/2016.

 Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number.

 Hint:

 1. The naive approach is to call isUgly for every number until you reach the nth one.

 2. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.

 3. An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.

 4. The key is how to maintain the order of the ugly numbers. Try a similar approach of
 merging from three sorted lists: L1, L2, and L3.

 5. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).


 */
public class N264_UglyNumber2 {
    // 32 ms
    // math, DP.
    public int nthUglyNumber(int n) {
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(1);
        int i2=0, i3=0, i5=0;
        while(ret.size()<n){
            int m2=ret.get(i2)*2, m3=ret.get(i3)*3, m5= ret.get(i5)*5;
            int min = Math.min(m2, Math.min(m3,m5));
            ret.add(min);
            // has to use if, not if else to remove duplicate
            if(min == m2) i2++;
            if(min == m3) i3++;
            if(min == m5) i5++;

        }
        return ret.get(ret.size()-1);
    }
}
