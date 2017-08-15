package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/16/2016.

 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26

 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.

 */
public class N91_DecodeWays {
    // facebook, microsoft, Uber
    // DP
    // XY could decode to: h(x), h(y), h(xy)
    // h(y) = h(x) + h(xy) if valid,  y= x+1
    // f(n) = f(n-1) + f(n-2) if valid
    // 259 / 259 test cases passed.
    // 5 ms
    public class Solution {
        public int numDecodings(String s) {
            if(s == null || s.length()==0 || s.charAt(0) == '0') return 0;
            int[] dp = new int[s.length()+1];
            dp[0]=1; dp[1]=1;

            for(int i=2; i<=s.length();i++){
                if(isValid(s.substring(i-1, i))) dp[i] += dp[i-1]; //check y
                if(isValid(s.substring(i-2, i))) dp[i] += dp[i-2]; //check xy
            }
            return dp[s.length()];
        }

        public boolean isValid(String s){
            if(s.charAt(0) == '0') return false;
            return Integer.valueOf(s) >=1 && Integer.valueOf(s)<=26;
        }
    }




    //TLE, but it saved all the decode ways
    public int numDecodings2(String s) {
        List<LinkedList<String>> ret = new LinkedList<LinkedList<String>>();
        if(s == null || s.length()==0) return 0;

        LinkedList<String> init_list = new LinkedList<>();
        init_list.add(String.valueOf(s.charAt(0) - '0'));
        ret.add(init_list);
        for(int i=1; i<s.length();i++){
            int num = s.charAt(i) - '0';
            int list_size = ret.size();
            for(int j=0;j<list_size;j++){
                LinkedList<String> list = ret.get(j);
                String last_num_in_list = list.getLast();
                String cur_num = last_num_in_list + num;
                if (Integer.valueOf(cur_num) <= 26) {
                    LinkedList<String> new_list = new LinkedList<>(list);
                    new_list.removeLast();
                    new_list.add(cur_num);
                    ret.add(new_list);
                }
                list.add(String.valueOf(num));
            }

            // remove tailing 0 list
            if(num == 0){
                Iterator<LinkedList<String>> it = ret.iterator();
                while(it.hasNext()) {
                    if(it.next().getLast().equals("0")){
                        it.remove();
                    }
                }
            }

        }
        return ret.size();
    }




}
