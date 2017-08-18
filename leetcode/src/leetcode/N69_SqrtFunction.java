package leetcode;

/**
 * Created by Hua on 6/8/2016.

 Implement int sqrt(int x).

 Compute and return the square root of x.

 */
public class N69_SqrtFunction {
    // Facebook, Bloomberg
    // binary search
    // need to use long type for mid*mid, or possibly over flow.
    // 1017 / 1017 test cases passed.  on 8/18/2017
    // 2 ms
    class Solution {
        public int mySqrt(int x) {
            if(x<=1) return x; // it seems OJ treat this way, not mathematically right

            int ret=1, left=1, right=x;
            while(left<=right){
                int mid = (right-left)/2 + left;
                long squareOfMid = (long)mid*mid;

                if(squareOfMid == x) return mid;
                else if(squareOfMid < x){
                    ret = mid;
                    left = mid+1;
                }else right = mid-1;
            }
            return ret;
        }
    }
}
