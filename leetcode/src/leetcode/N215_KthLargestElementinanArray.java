package leetcode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by Hua on 3/21/2016.

 Find the kth largest element in an unsorted array.
 Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.

 */
public class N215_KthLargestElementinanArray {
    // use heap, extra space but faster, space o(k), time o(nlogk)
    // 8 ms 31 / 31 test cases passed.  resubmitted on 10/22/2016
    public int findKthLargest_use_heap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);

        for(int e : nums){
            if(heap.size()<k) heap.add(e);
            else{
                if(e > heap.peek()) {
                    heap.poll();
                    heap.add(e);
                }
            }
        }
        return heap.poll();
    }


    // quick select using random added 10/22/2016
    // this problem is slight different, it's find kth largest item rather than kth item.
    // so the order is reversed, meaning kth in reversed order.
    // 5 ms 31 / 31 test cases passed.
    public class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(k > nums.length) throw new IllegalArgumentException("K is larger than size of num");
            return select(nums, 0, nums.length-1, k-1);
        }

        public int select(int[] nums, int start, int end, int k){
            if(start > end) return nums[start]; // one element case

            int pIndex = new Random().nextInt(end-start+1) + start; // select a random index in [start,end]
            pIndex = partition(nums, start, end, pIndex);  // get new pIndex by moving item around pIndex

            if (pIndex == k) return nums[pIndex];
            else if(pIndex < k) return select(nums, pIndex+1, end, k);
            else return select(nums, start, pIndex-1, k);
        }

        // this parition is reversed order, max --> min
        public int partition(int nums[], int start, int end, int pIndex){
            swap(nums, pIndex, end);  // swap pIndex with end
            int ret = start;
            for(int i=start;i<end;i++){
                if(nums[i] > nums[end]) { // both > or >= should work here, if natural order, change to <
                    swap(nums, i, ret);
                    ret++;
                }
            }
            swap(nums, ret, end);
            return ret;
        }

        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    // compare with quickselect above
    public class Sort {
        public void quicksort(int[] nums) {
            if(nums == null) throw new IllegalArgumentException("nums is null");
            quicksort(nums, 0, nums.length-1);
        }

        private void quicksort(int[] nums, int start, int end){
            if(start >= end) return;

            int pIndex = new Random().nextInt(end-start+1) + start; // select a random index in [start,end]
            pIndex = partition(nums, start, end, pIndex);  // get new pIndex by moving item around pIndex
            quicksort(nums, start, pIndex-1);
            quicksort(nums, pIndex+1, end);
        }

        // this parition is reversed order, max --> min
        private int partition(int nums[], int start, int end, int pIndex){
            swap(nums, pIndex, end);  // swap pIndex with end
            int ret = start;
            for(int i=start;i<end;i++){
                if(nums[i] < nums[end]) { // natural order so it's <
                    swap(nums, i, ret);
                    ret++;
                }
            }
            swap(nums, ret, end);
            return ret;
        }

        private void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    public static void main(String[] args){
        N215_KthLargestElementinanArray.Sort x = new N215_KthLargestElementinanArray().new Sort();
        int[][] data = new int[][]{
            new int[]{1,2,3},
            new int[]{3,2,1},
            new int[]{6,5,3,9,0},
            new int[]{4,3,2,1},
            new int[]{1},
            new int[]{},
        };
        for(int[] e: data){
            x.quicksort(e);
            System.out.println(Arrays.toString(e));
        }

        HashMap<Integer, Integer> map = new HashMap();
        map.put(1,10);
        int ret = map.remove(1);
        System.out.println("ret="+ret);

    }

}
