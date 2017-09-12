package leetcode;

/**
 * Created by Hua on 7/18/2017.

 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Find all strobogrammatic numbers that are of length = n.

 For example,
 Given n = 2, return ["11","69","88","96"].


 */

import java.util.*;
public class N247_StrobogrammaticNumberII {
    // google (Premium)
    // more concise code
    // build string inside out
    // 13 / 13 test cases passed.
    // 24 ms
    public class Solution2 {
        public List<String> findStrobogrammatic(int n) {
            return dfs(n, n);
        }

        public List<String> dfs(int m, int n){
            if(m == 0) return new ArrayList(Arrays.asList(""));  // important, can't be empty
            if(m == 1) return new ArrayList(Arrays.asList("0", "1", "8"));

            List<String> list = dfs(m - 2, n);
            List<String> ret = new ArrayList();
            for(String s : list){
                if(m != n) ret.add("0" + s + "0");
                ret.add("1" + s + "1");
                ret.add("8" + s + "8");
                ret.add("6" + s + "9");
                ret.add("9" + s + "6");
            }
            return ret;
        }
    }

    // 13 / 13 test cases passed.
    // 33 ms
    // dfs, build left and right
    public class Solution {
        public List<String> findStrobogrammatic(int n) {
            List<String> ret = new ArrayList();
            dfs(ret, "", n%2==1, n/2);
            return ret;
        }

        public void dfs(List<String> ret, String cur, boolean isOdd, int length){
            if(cur.length() == length){
                if(isOdd) {
                    for(String s : Arrays.asList("1", "0", "8")){
                        ret.add(cur + s + getReverse(cur));
                    }
                    return;
                }
                ret.add(cur + getReverse(cur));
                return;
            }

            for(String s: Arrays.asList("1", "0", "8", "6", "9")){
                if(cur.length() == 0 && s.equals("0")) continue;
                dfs(ret, cur + s, isOdd, length);
            }
        }

        public String getReverse(String cur){
            StringBuilder sb = new StringBuilder();
            for(char c : cur.toCharArray()){
                if(c == '6') sb.append("9");
                else if(c == '9') sb.append("6");
                else sb.append(c);
            }
            return sb.reverse().toString();
        }
    }



}
