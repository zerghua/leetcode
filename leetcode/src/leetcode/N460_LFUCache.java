package leetcode;

/**
 * Created by Hua on 6/9/2017.

 Design and implement a data structure for Least Frequently Used (LFU) cache.
 It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

    LFUCache cache = new LFUCache( 2 ); // capacity
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.get(3);       // returns 3.
    cache.put(4, 4);    // evicts key 1.
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4

 */
import java.util.*;
public class N460_LFUCache {
    // Amazon, Google
    // linkedhashset has o(1) remove/get and ordered list compared to linkedlist which has o(n) remove/get for any item.
    // 3 hashmap + linkedHashset.
    // 23 / 23 test cases passed.
    // 277 ms
    public class LFUCache {
        HashMap<Integer, Integer> countMap;             // key -> count of frequency
        HashMap<Integer, Integer> valueMap;             // key -> value
        HashMap<Integer, LinkedHashSet<Integer>> list;  // count -> list of keys,
        int capacity, minCount;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            minCount = 0;
            countMap = new HashMap();
            valueMap = new HashMap();
            list = new HashMap();
            list.put(1, new LinkedHashSet<>());
        }

        public int get(int key) {
            if(!valueMap.containsKey(key)) return -1;

            // update count map
            int curCount = countMap.get(key);
            countMap.put(key, curCount + 1);

            // update list(count of each key grouped by count)
            list.get(curCount).remove(key);
            if(!list.containsKey(curCount+1)) list.put(curCount+1, new LinkedHashSet());
            list.get(curCount+1).add(key);

            // update minCount
            if(curCount == minCount && list.get(curCount).size() == 0) minCount++;

            return valueMap.get(key);
        }

        public void put(int key, int value) {
            if(capacity <= 0 ) return ;

            if(valueMap.containsKey(key)){
                valueMap.put(key, value);
                get(key);  // update frequency
                return ;
            }

            if(valueMap.size() >= capacity){
                int keyToBeRemoved = list.get(minCount).iterator().next();
                valueMap.remove(keyToBeRemoved);
                countMap.remove(keyToBeRemoved);
                list.get(minCount).remove(keyToBeRemoved);
            }

            valueMap.put(key, value);
            countMap.put(key, 1);
            minCount = 1;
            list.get(1).add(key);
        }
    }
}
