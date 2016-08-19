package leetcode;
import java.util.*;

/**
 * Created by HuaZ on 8/18/2016.

 You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from
 the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:

 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

 Example 2:

 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

 Example 3:

 Given nums1 = [1,2], nums2 = [3],  k = 3

 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]


 */
public class N373_FindKPairswithSmallestSums {
    class Pairs{
        int[] pair;
        int sumOfPair;
        public Pairs(int a, int b){
            pair = new int[]{a,b};
            sumOfPair = a+b;
        }
    }

    // 126 ms  o(n^2) time,  priority queue
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if(nums1 == null || nums1.length==0 || nums2 == null || nums2.length==0)  // corner case
            return ret;

        PriorityQueue<Pairs> heap = new PriorityQueue<>((e1,e2) -> e1.sumOfPair - e2.sumOfPair);
        for(int a: nums1){
            for(int b: nums2){
                heap.add(new Pairs(a,b));
            }
        }
        for(int i=0;i<k && !heap.isEmpty();i++){ // corner case
            Pairs p = heap.remove();
            ret.add(new int[]{p.pair[0], p.pair[1]});
        }
        return ret;
    }

    // more optimized way
    // https://discuss.leetcode.com/topic/51568/java-4ms-simple-solution-using-only-arrays
    // https://discuss.leetcode.com/topic/50527/java-10ms-solution-no-priority-queue/5

}
