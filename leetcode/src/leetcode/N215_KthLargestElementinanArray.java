package leetcode;
import java.util.PriorityQueue;

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

    // quick sort, time o(nlogn), in place
    public int get_pivot_index(int[] nums, int start, int end, int k){
        if(start > end) return nums[end];

        int pivot_val = nums[end]; //pivot choosing can be optimised
        int pivot_index=start;
        for(int i=start; i<end; i++){
            //swap if less than pivot value
            if (nums[i] >= pivot_val){
                int tmp = nums[i];
                nums[i] = nums[pivot_index];
                nums[pivot_index] = tmp;
                pivot_index++;
            }
        }

        //swap pivot to its index
        nums[end] = nums[pivot_index];
        nums[pivot_index] = pivot_val;

        //recursion
        if(pivot_index == k) return nums[pivot_index];
        else if(pivot_index > k) return get_pivot_index(nums, start, pivot_index-1, k);
        else return get_pivot_index(nums, pivot_index+1, end, k);
    }


    public int findKthLargest(int[] nums, int k) {
        return  get_pivot_index(nums, 0, nums.length-1, k);
    }



    //use heap, extra space but faster, space o(k), time o(nlogn)
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
}
