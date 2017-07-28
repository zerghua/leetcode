package leetcode;

/**
 * Created by Hua on 7/28/2017.

 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

 For example,
 Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

 Note:
 Because the range might be a large number, the low and high numbers are represented as string.

 */

import java.util.*;
public class N248_StrobogrammaticNumberIII {
    // google
    // adapted from N247. Strobogrammatic Number II
    // 16 / 16 test cases passed.
    // 78 ms
    public class Solution {
        public int strobogrammaticInRange(String low, String high) {
            List<String> list = new ArrayList();
            for(int i=low.length(); i<= high.length(); i++){
                list.addAll(dfs(i,i));
            }

            int ret = 0;
            for(String s : list){
                if((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) continue;
                ret++;
            }
            return ret;
        }


        public List<String> dfs(int m, int n){
            if(m == 0) return new ArrayList(Arrays.asList(""));
            if(m == 1) return new ArrayList(Arrays.asList("0", "1", "8"));

            List<String> ret = new ArrayList();
            for(String s : dfs(m-2, n)){
                if(m != n) ret.add("0" + s + "0"); // 0 can't be the outermost
                ret.add("1" + s + "1");
                ret.add("8" + s + "8");
                ret.add("6" + s + "9");
                ret.add("9" + s + "6");
            }
            return ret;
        }
    }

}
