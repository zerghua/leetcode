package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 9/16/2017.
 Rank	    Name	Score	 Finish Time 	Q1 (3)	    Q2 (5)	    Q3 (7)	    Q4 (9)
 76 / 2703	zerghua	25	     1:15:58	    0:08:20 	0:13:12 	0:22:26 	1:15:58



 */
public class Contest_50 {
    // two pointers
    class Solution {
        public boolean validPalindrome(String s) {
            int i=0, j = s.length()-1;
            while(i<j){
                if(s.charAt(i) == s.charAt(j)) {
                    i++;j--;
                }else return isPal(s, i+1, j) || isPal(s, i, j-1);
            }
            return true;
        }

        public boolean isPal(String s, int i, int j){
            while(i < j){
                if(s.charAt(i) == s.charAt(j)){
                    i++;j--;
                }else return false;
            }
            return true;
        }
    }


    // BF
    class MapSum {
        HashMap<String, Integer> map ;
        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int ret = 0;
            for(String s: map.keySet()){
                if(s.startsWith(prefix))  ret+= map.get(s);
            }
            return ret;
        }
    }


    // recursion dfs
    class Solution3 {
        public boolean checkValidString(String s) {
            return isValid(s, 0);
        }

        public boolean isValid(String s, int leftCount){
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '(') leftCount++;
                else if(c == ')') {
                    if(leftCount < 1) return false;
                    leftCount--;
                } else{ // c =='*'
                    return isValid(s.substring(i+1), leftCount)
                            || isValid(s.substring(i+1), leftCount+1)
                            || isValid(s.substring(i+1), leftCount-1);
                }
            }
            return leftCount == 0;
        }
    }



    // backtracking, divide and conquer
    class Solution4 {
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
