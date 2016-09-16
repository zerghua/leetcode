package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/9/2016.
 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
 repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that
 occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].


 */

//remember how to iterate hashmap
public class N187_RepeatedDNASequences {
    //53 ms  o(n) time,
    //84 ms 32 / 32 test cases passed.  on 9/16/2016
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new LinkedList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String sequence = s.substring(i,i+10);
            if(hm.containsKey(sequence))hm.put(sequence, hm.get(sequence)+1);
            else hm.put(sequence, 1);
        }

        for(Map.Entry<String, Integer> e: hm.entrySet()){
            if(e.getValue() >1) ret.add(e.getKey());
        }
        return ret;
    }

    // version 2 added 9/16/2016
    // 62 ms 32 / 32 test cases passed.
    // two hashset to make code cleaner
    public class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            HashSet<String> seen = new HashSet<>(), ret = new HashSet<>();
            for(int i=0;i<=s.length()-10;i++){
                String str = s.substring(i,i+10);
                if(!seen.add(str)) ret.add(str);
            }
            return new ArrayList<>(ret);
        }
    }

}
