package leetcode;
import java.util.*;

/**
 * Created by Hua on 5/24/2016.

 Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:

 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.




 */
public class N347_TopKFrequentElements {
    // Yelp
    //43 ms
    // hashmap + custom priority queue
    // time nlogk
    class Pair{
        int key;
        int count;
        public Pair(int key, int count){
            this.key = key;
            this.count = count;
        }
    }

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
        PriorityQueue<Pair> min_heap = new PriorityQueue<>(k, (o1, o2) -> o1.count -o2.count);

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


    // bucket sort, use count as index, list of key as value. time o(N)
    // added on 9/25/2016
    // 26 ms  20 / 20 test cases passed.
    public class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap();
            for(int n: nums) map.put(n, map.getOrDefault(n,0)+1);

            // bucket use count as index
            ArrayList<Integer>[] buckets = new ArrayList[nums.length+1];
            for(int key: map.keySet()){
                int count = map.get(key);
                if(buckets[count] == null) buckets[count] = new ArrayList<>();
                buckets[count].add(key);
            }

            // select k from bucket, assume k is always valid
            List<Integer> ret = new ArrayList<>();
            for(int i=buckets.length-1; i>=0 && ret.size()<k ; i--){
                if(buckets[i]!=null) {
                    ret.addAll(buckets[i]);
                }
            }
            return ret;
        }
    }
}
