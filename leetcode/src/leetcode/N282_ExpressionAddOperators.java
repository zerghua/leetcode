package leetcode;

import java.util.*;

/**
 * Created by Hua on 8/7/16.

 Given a string that contains only digits 0-9 and a target value,
 return all possibilities to add binary operators (not unary) +, -, or * between
 the digits so they evaluate to the target value.


 Examples:

 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []


 */
public class N282_ExpressionAddOperators {
    // Google, Facebook
    // Backtracking
    // 20 / 20 test cases passed.  on 8/15/2017
    // 268 ms
    public class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> ret = new ArrayList<>();
            dfs(ret, num, target, "", 0, 0, 0);
            return ret;
        }

        public void dfs(List<String> ret, String num, int target, String path, int pos, long sum, long lastNum){
            if(pos == num.length()){
                if(sum == target) ret.add(path);
                return;
            }
            for(int i=pos; i<num.length();i++){
                if(num.charAt(pos) == '0' && pos != i) break; // skip corner case like 000
                long cur = Long.parseLong(num.substring(pos,i+1));
                if(pos == 0) dfs(ret, num, target, path + cur, i+1, cur, cur);  //first num, has to be i+1
                else{
                    dfs(ret, num, target, path + "+" + cur, i+1, sum+cur, cur);
                    dfs(ret, num, target, path + "-" + cur, i+1, sum-cur, -cur);
                    dfs(ret, num, target, path + "*" + cur, i+1, sum-lastNum + lastNum*cur, lastNum*cur);
                }
            }
        }
    }
}
