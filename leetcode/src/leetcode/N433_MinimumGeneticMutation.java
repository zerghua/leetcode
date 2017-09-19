package leetcode;

/**
 * Created by Hua on 8/10/2017.

 A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

 Suppose we need to investigate about a mutation (mutation from "start" to "end"),
 where ONE mutation is defined as ONE single character changed in the gene string.

 For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

 Also, there is a given gene "bank", which records all the valid gene mutations.
 A gene must be in the bank to make it a valid gene string.

 Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed
 to mutate from "start" to "end". If there is no such a mutation, return -1.

 Note:

 Starting point is assumed to be valid, so it might not be included in the bank.
 If multiple mutations are needed, all mutations during in the sequence must be valid.
 You may assume start and end string is not the same.

 Example 1:

 start: "AACCGGTT"
 end:   "AACCGGTA"
 bank: ["AACCGGTA"]

 return: 1

 Example 2:

 start: "AACCGGTT"
 end:   "AAACGGTA"
 bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

 return: 2

 Example 3:

 start: "AAAAACCC"
 end:   "AACCCCCC"
 bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

 return: 3

 */

import java.util.*;
public class N433_MinimumGeneticMutation {
    // BFS, identical to word ladder
    // 14 / 14 test cases passed.
    // 2 ms
    public class Solution {
        public int minMutation(String start, String end, String[] bank) {
            boolean[] isUsed = new boolean[bank.length];
            LinkedList<String> list = new LinkedList();
            list.add(start);
            int ret = 0;

            while(!list.isEmpty()){
                int size = list.size();

                for(int i = 0 ; i<size; i++) {
                    String cur = list.removeFirst();
                    if (cur.equals(end)) return ret;

                    for (int j = 0; j< bank.length; j++) {
                        if (isUsed[j]) continue;
                        if (diff(cur, bank[j]) == 1) {
                            list.add(bank[j]);
                            isUsed[j] = true;
                        }
                    }
                }
                ret++;
            }

            return -1;
        }

        public int diff(String s, String t){
            int ret = 0;
            for(int i=0; i<s.length(); i++) if(s.charAt(i) != t.charAt(i)) ret++;
            return ret;
        }
    }


    // HashMap + BFS
    // 14 / 14 test cases passed.
    // 2 ms
    public class Solution2 {
        public int minMutation(String start, String end, String[] bank) {
            HashMap<String, Integer> map = new HashMap();
            for(String s : bank) map.put(s, 0);
            map.put(start, 0);

            if(!map.containsKey(end)) return -1;

            LinkedList<String> list = new LinkedList();
            list.add(start);

            while(!list.isEmpty()){
                String cur = list.removeFirst();
                if(cur.equals(end)) return map.get(cur);
                for(String s : bank){
                    if(map.get(s) != 0) continue;
                    if(diff(cur, s) == 1) {
                        list.add(s);
                        map.put(s, map.get(cur) + 1);
                    }
                }
            }

            return -1;
        }

        public int diff(String s, String t){
            int ret = 0;
            for(int i=0; i<s.length(); i++) if(s.charAt(i) != t.charAt(i)) ret++;
            return ret;
        }
    }
}
