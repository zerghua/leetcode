package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/10/2016.
 */
public class N93_RestoreIPAddresses {
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
