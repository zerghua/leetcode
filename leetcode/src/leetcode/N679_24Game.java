package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 9/18/2017.

 You have 4 cards each containing a number from 1 to 9.
 You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

 Example 1:

 Input: [4, 1, 8, 7]
 Output: True
 Explanation: (8-4) * (7-1) = 24

 Example 2:

 Input: [1, 2, 1, 2]
 Output: False

 Note:

 The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
 Every operation done is between two numbers. In particular, we cannot use - as a unary operator.
 For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
 You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2],
 we cannot write this as 12 + 12.


 */
public class N679_24Game {
    // backtracking, others concise solution
    // generate each pair and pass down new array
    // 70 / 70 test cases passed.
    // 11 ms
    class Solution {
        public boolean judgePoint24(int[] nums) {
            return dfs(new double[]{nums[0], nums[1], nums[2], nums[3]});
        }

        public boolean dfs(double[] a){
            if(a.length == 1) return Math.abs(a[0] -24) < 0.01;

            // for each pair of a
            for(int i=0; i<a.length; i++){
                for(int j=i+1; j<a.length; j++){

                    // copy remaining to b array
                    double[] b = new double[a.length-1];
                    for(int k=0, l =0; k<a.length; k++) {
                        if(k != i && k != j) b[l++] = a[k];
                    }

                    for(double d : ops(a[i], a[j])){
                        b[a.length-2] = d;  // set end of b as result of a[i] and a[j]
                        if(dfs(b)) return true;
                    }
                }
            }
            return false;
        }

        public double[] ops(double a, double b){
            return new double[]{a+b, a-b, b-a, a*b, a/b, b/a};
        }
    }


    // my contest 50 solution
    // 70 / 70 test cases passed.
    // 23 ms
    class Solution2 {
        boolean isFound = false;
        public boolean judgePoint24(int[] nums) {
            return two(nums[0], nums[1], nums[2], nums[3])
                    || two(nums[0], nums[2], nums[1], nums[3])
                    || two(nums[0], nums[3], nums[2], nums[3])
                    || four(nums[0], nums[1], nums[2], nums[3])
                    || four(nums[1], nums[0], nums[2], nums[3])
                    || four(nums[2], nums[1], nums[0], nums[3])
                    || four(nums[3], nums[1], nums[2], nums[0]);

        }

        public boolean four(int a, int b, int c, int d){
            for(Double x : three(b,c,d)){
                List<Double> ret = ops(x,a);
                for(Double r: ret) {
                    if ((int) Math.round(r) == 24) {
                        isFound = true;
                        break;
                    }
                }
                if(isFound) break;
            }
            return isFound;
        }

        public List<Double> three(int a, int b, int c){
            List<Double> ret = new ArrayList();
            for(Double x : ops(a,b)) ret.addAll(ops(x, c));
            for(Double x : ops(a,c)) ret.addAll(ops(x, b));
            for(Double x : ops(b,c)) ret.addAll(ops(x, a));
            return ret;
        }

        public boolean two(int a, int b, int c, int d){
            // two and two
            List<Double> left = ops(a,b);
            List<Double> right = ops(c,d);
            for(double i : left){
                for(double j : right){
                    List<Double> ret = ops(i,j);
                    for(Double r: ret){
                        if((int)Math.round(r) == 24) {
                            isFound = true;
                            break;
                        }
                    }
                    if(isFound) break;
                }
                if(isFound) break;
            }
            return isFound;
        }

        // no 0 input
        public List<Double> ops(double a, double b){
            List<Double> ret = new ArrayList();
            ret.add((double)a + b);
            ret.add((double)a - b);
            ret.add((double)b - a);
            ret.add((double)a * b);
            ret.add((double)a / b);
            ret.add((double)b / a);
            return ret;
        }
    }
}
