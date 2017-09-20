package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/10/2016.

 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 */
public class N93_RestoreIPAddresses {
    // no company
    // version 2 added on 9/11/2016
    // 5 ms  147 / 147 test cases passed.
    // a little more readable code. DFS + backtracking
    // extra position to indicate how many level we are in.
    // pruning for case like 00, 01
    public class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> ret = new ArrayList<>();
            dfs(ret, "", s, 0, 0);
            return ret;
        }

        public void dfs(List<String> ret, String cur_string, String s, int start, int pos){
            if(pos == 4 ){
                if(start >= s.length()) ret.add(cur_string.substring(1));
                return;
            }
            for(int i=start; i<start+3 && i<s.length(); i++){
                String ip = s.substring(start, i+1);
                if(Integer.valueOf(ip)<=255){
                    dfs(ret, cur_string+"."+ip, s, i+1, pos+1);

                    if(Integer.valueOf(ip) == 0) break; // important, skip something like 00, 01
                }
            }
        }
    }


    //5 ms, many corner cases.
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<>();
        restoreIpAddresses(s, 0, 0, "", ret);
        return ret;
    }

    public void restoreIpAddresses(String s, int start, int ip_postition,
                                   String cur_string, List<String> ret){
        if(ip_postition >=4 ){
            if(start == s.length()) ret.add(new String(cur_string.substring(1)));
            return;
        }

        for(int i=start+1; i<=start+3 && i<=s.length(); i++){
            String ip = s.substring(start, i);
            if(Integer.valueOf(ip) <= 255){
                restoreIpAddresses(s, i, ip_postition+1, cur_string+"."+ip, ret);

                // to skip number start with 0, like 00, 01
                if(Integer.valueOf(ip) == 0) break;
            }
        }
    }


}
