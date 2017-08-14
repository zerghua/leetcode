package leetcode;

import java.util.*;

/**
 * Created by Hua on 8/14/2017.

 Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

 Example 1:

 Input: [1,2,3,4,5], k=4, x=3
 Output: [1,2,3,4]

 Example 2:

 Input: [1,2,3,4,5], k=4, x=-1
 Output: [1,2,3,4]

 Note:

 The value k is positive and will always be smaller than the length of the sorted array.
 Length of the given array is positive and will not exceed 104
 Absolute value of elements in the array and x will not exceed 104


 */
public class N658_FindKClosestElements {
    // o(nlogn)
    // 55 / 55 test cases passed.
    // 173 ms
    public class Solution {
        public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
            for(Integer num : arr){
                if(heap.size() < k) heap.add(new int[]{Math.abs(num-x), num});
                else{
                    int diff = Math.abs(num - x);
                    if(diff < heap.peek()[0]){
                        heap.remove();
                        heap.add(new int[]{diff, num});
                    }
                }
            }
            List<Integer> ret = new LinkedList();
            while(!heap.isEmpty()) ret.add(heap.remove()[1]);
            Collections.sort(ret);
            return ret;
        }
    }

    // o(nlogn)
    // 55 / 55 test cases passed.
    // 128 ms
    public class Solution2 {
        public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            Collections.sort(arr, (a, b) -> Math.abs(a - x) - Math.abs(b - x));
            arr = arr.subList(0, k);
            Collections.sort(arr);
            return arr;
        }
    }


    // o(n)
    // 55 / 55 test cases passed.
    // 51 ms
    public class Solution3 {
        public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            List<Integer> less = new ArrayList<>(), greater = new ArrayList<>(),
                    lessResult = new LinkedList<>(), greaterResult = new LinkedList<>();

            for (Integer i : arr) {
                if (i <= x) less.add(i);
                else greater.add(i);
            }

            Collections.reverse(less);
            int  i = 0, j = 0, n = less.size(), m = greater.size();
            for (int size=0;size<k;size++) {
                if (i < n && j < m) {
                    if (Math.abs(less.get(i) - x) <= Math.abs(greater.get(j) - x)) lessResult.add(less.get(i++));
                    else greaterResult.add(greater.get(j++));
                }
                else if (i < n) lessResult.add(less.get(i++));
                else greaterResult.add(greater.get(j++));
            }

            Collections.reverse(lessResult);
            lessResult.addAll(greaterResult);
            return lessResult;
        }
    }

}
