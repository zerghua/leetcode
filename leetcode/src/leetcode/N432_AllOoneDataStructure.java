package leetcode;

/**
 * Created by Hua on 6/28/2017.

 Implement a data structure supporting the following operations:

 Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.

 Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1.
 If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.

 GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".

 GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".

 Challenge: Perform all these in O(1) time complexity.

 */

import java.util.*;
public class N432_AllOoneDataStructure {
    // Uber
    // naive solution, get max and min are o(n)
    // all o(1) solution involves creates list of buckets hash to find them.
    // 15 / 15 test cases passed.
    // 140 ms
    public class AllOne {
        HashMap<String, Integer> map;

        /** Initialize your data structure here. */
        public AllOne() {
            map = new HashMap();
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            if(!map.containsKey(key)) map.put(key, 1);
            else map.put(key, map.get(key) + 1);
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if(map.containsKey(key)){
                if(map.get(key) == 1) map.remove(key);
                else map.put(key, map.get(key) - 1);
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if(map.isEmpty()) return "";
            String ret = "";
            int max = 0;
            for(String key: map.keySet()){
                if(map.get(key) > max){
                    max = map.get(key);
                    ret = key;
                }
            }
            return ret;
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if(map.isEmpty()) return "";
            String ret= "";;
            int min = Integer.MAX_VALUE;
            for(String key: map.keySet()){
                if(map.get(key) < min){
                    min = map.get(key);
                    ret = key;
                }
            }
            return ret;
        }
    }

}
