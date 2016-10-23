package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/23/2016.

 Uber phone interview question

 Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements.
 Each element must have the same probability of being returned.

 Example:

 // Init an empty set.
 RandomizedSet randomSet = new RandomizedSet();

 // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 randomSet.insert(1);

 // Returns false as 2 does not exist in the set.
 randomSet.remove(2);

 // Inserts 2 to the set, returns true. Set now contains [1,2].
 randomSet.insert(2);

 // getRandom should return either 1 or 2 randomly.
 randomSet.getRandom();

 // Removes 1 from the set, returns true. Set now contains [2].
 randomSet.remove(1);

 // 2 was already in the set, so return false.
 randomSet.insert(2);

 // Since 1 is the only number in the set, getRandom always return 1.
 randomSet.getRandom();


 */
public class N380_InsertDeleteGetRandomO1 {
    // requirement:  insert, delete, getRandom all of average o(1) time.
    // hashtable can make insert and delete o(1), but getRandom will need o(n)
    // ArrayList can make getRandom o(1), o(1) to insert/delete at the end, o(n) at other places.
    // so we combine those two, HashMap<value, index>
    // 131 ms 18 / 18 test cases passed.
    public class RandomizedSet {
        HashMap<Integer, Integer> map;  // value and index pair
        ArrayList<Integer> list;
        Random rand;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap();
            list = new ArrayList();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        // one trick to make delete from array o(1) is to swap it with last item, and remove last one.
        // downside is not ordered anymore.
        public boolean remove(int val) {
            if(map.isEmpty() || !map.containsKey(val)) return false;
            int index = map.get(val);
            int lastItem = list.get(list.size()-1);
            map.put(lastItem, index);   // important! update last one's new index
            list.set(index, lastItem);  // copy last one to this index
            list.remove(list.size()-1); // remove last one by index
            map.remove(val);            // remove item in map
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            if(map.isEmpty()) throw new IllegalArgumentException("no element to choose");
            int index = rand.nextInt(list.size());
            return list.get(index);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
