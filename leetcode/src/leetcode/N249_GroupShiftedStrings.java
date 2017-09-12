package leetcode;

/**
 * Created by Hua on 7/17/2017.

 Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"

 Given a list of strings which contains only lowercase alphabets,
 group all strings that belong to the same shifting sequence.

 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 A solution is:

 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]


 */

import java.util.*;
public class N249_GroupShiftedStrings {
    // Google, Uber (Premium)
    // need a good hash function, my hash function: (s.charAt(i) - s.charAt(i-1) + 26) % 26 + 'a'
    // slightly concise code. each char minus the same offset. the first one is easier to thought through.
    // 23 / 23 test cases passed.
    // 5 ms
    public class Solution2 {
        public List<List<String>> groupStrings(String[] strings) {
            List<List<String>> ret = new ArrayList();
            HashMap<String, List<String>> map = new HashMap();
            for(String s : strings){
                StringBuilder sb = new StringBuilder();
                int offset = s.charAt(0) - 'a';
                for(int i=0;i<s.length();i++) sb.append((s.charAt(i) - offset + 26) % 26 + 'a');

                String key = sb.toString();
                if(!map.containsKey(key))map.put(key, new ArrayList());
                map.get(key).add(s);
            }
            ret.addAll(map.values());
            return ret;
        }
    }


    // 23 / 23 test cases passed.
    // 5 ms
    public class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            List<List<String>> ret = new ArrayList();
            HashMap<String, List<String>> map = new HashMap();
            List<String> single = new ArrayList();
            for(String s : strings){
                if(s.length() == 1) single.add(s);
                else {
                    StringBuilder sb = new StringBuilder();
                    for(int i=1;i<s.length();i++) sb.append((s.charAt(i) - s.charAt(i-1) + 26) % 26 + 'a');

                    String key = sb.toString();
                    if(!map.containsKey(key))map.put(key, new ArrayList());
                    map.get(key).add(s);
                }
            }

            if(!single.isEmpty()) ret.add(single);
            ret.addAll(map.values());
            return ret;
        }
    }


}
