package leetcode;
import java.util.*;

/**
 * Created by Hua on 5/24/2016.

 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:

 You may assume k is always valid, 1 ¡Ü k ¡Ü number of unique elements.
 Your algorithm's time complexity must be better than O(n log n),
 where n is the array's size.



 */
public class N347_TopKFrequentElements {
    class Pair{
        int key;
        int count;
        public Pair(int key, int count){
            this.key = key;
            this.count = count;
        }
    }

    //43 ms
    // hashmap + custom priority queue
    // time nlogk
    public List<Integer> topKFrequent(int[] nums, int k) {
        // hashmap to count
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int e: nums){
            //if(hm.containsKey(e))hm.put(e, hm.get(e)+1);
            //else hm.put(e, 1);

            //above can be optimized as one line below
            hm.put(e, hm.getOrDefault(e,0)+1);
        }

        // min_heap to get top K
        PriorityQueue<Pair> min_heap = new PriorityQueue<>(k,
                new Comparator<Pair>() {
                    public int compare(Pair o1, Pair o2) {
                        return o1.count - o2.count;
                    }
                });

        for(int key: hm.keySet()){
            if(min_heap.size()<k) min_heap.add(new Pair(key, hm.get(key)));
            else if(hm.get(key) > min_heap.peek().count) {
                min_heap.poll();
                min_heap.offer(new Pair(key, hm.get(key)));
            }
        }

        List<Integer> ret = new ArrayList<>();
        for(Pair p: min_heap) ret.add(p.key);
        return ret;
    }


    //TODO,  bucket sort, use count as index, list of key as value. time o(N)

}
