package leetcode;
import java.util.*;


/**
 * Created by HuaZ on 10/23/2016.

 Design a data structure that supports all following operations in average O(1) time.
 Note: Duplicate elements are allowed.

 insert(val): Inserts an item val to the collection.
 remove(val): Removes an item val from the collection if present.
 getRandom: Returns a random element from current collection of elements.
 The probability of each element being returned is linearly related to the number of same value
 the collection contains.

 Example:

 // Init an empty collection.
 RandomizedCollection collection = new RandomizedCollection();

 // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 collection.insert(1);

 // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 collection.insert(1);

 // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 collection.insert(2);

 // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 collection.getRandom();

 // Removes 1 from the collection, returns true. Collection now contains [1,2].
 collection.remove(1);

 // getRandom should return 1 and 2 both equally likely.
 collection.getRandom();


 */
public class N381_InsertDeleteGetRandomO1_Duplicatesallowed {
    // 145 ms, 28 / 28 test cases passed.
    // set.iterator().next() to get item in set.
    public class RandomizedCollection {
        HashMap<Integer, HashSet<Integer>> map;  // value and index pair
        ArrayList<Integer> list;
        Random rand;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap();
            list = new ArrayList();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean ret = false;
            if(!map.containsKey(val)) {
                map.put(val, new HashSet<>());
                ret = true;
            }
            map.get(val).add(list.size());
            list.add(val);
            return ret;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        // one trick to make delete from array o(1) is to swap it with last item, and remove last one.
        // downside is not ordered anymore.
        public boolean remove(int val) {
            if(map.isEmpty() || !map.containsKey(val)) return false;

            int lastIndex = list.size()-1;
            if(!map.get(val).contains(lastIndex)){ //if not last, swap cur with last element in map and list
                int lastVal = list.get(lastIndex);
                int curIndex = map.get(val).iterator().next();
                map.get(lastVal).remove(lastIndex);
                map.get(lastVal).add(curIndex);
                map.get(val).remove(curIndex);
                map.get(val).add(lastIndex);
                list.set(curIndex, lastVal);
            }
            map.get(val).remove(lastIndex);
            if(map.get(val).isEmpty()) map.remove(val);
            list.remove(lastIndex);
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
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}
