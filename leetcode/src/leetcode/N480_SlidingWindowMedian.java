package leetcode;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by HuaZ on 6/3/2017.

 Median is the middle value in an ordered integer list. If the size of the list is even,
 there is no middle value. So the median is the mean of the two middle value.
 Examples:

 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Given an array nums, there is a sliding window of size k which is moving from the very left of
 the array to the very right. You can only see the k numbers in the window. Each time the sliding
 window moves right by one position. Your job is to output the median array for each window in the
 original array.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Median
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6

 Therefore, return the median sliding window as [1,-1,-1,3,5,6].

 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

 However instead of using two priority queue's we use two Tree Sets as we want O(logk) for
 remove(element).
 Priority Queue would have been O(k) for remove(element) giving us an overall time complexity of O(nk)
 instead of O(nlogk).

 However there is an issue when it comes to duplicate values so to get around this we store the index
 into nums in our Tree Set. To break ties in our Tree Set comparator we compare the index.

 */
public class N480_SlidingWindowMedian {
    // Google
    // very simiar to N295, find median from data stream.
    // here use BST(treemap) to make time complexity to o(nlogk) rather than heap o(nk)
    // 42 / 42 test cases passed.
    // 282 ms
    public class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            Comparator<Integer> comp = (a,b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
            TreeSet<Integer> left = new TreeSet(comp.reversed());
            TreeSet<Integer> right = new TreeSet(comp);

            double[] ret = new double[nums.length - k + 1];
            for(int i=0; i<k; i++) left.add(i);
            balance(left, right);
            ret[0] = getMedian(left, right, k, nums);

            for(int i=k; i<nums.length; i++){
                if(!left.remove(i-k)) right.remove(i-k);

                right.add(i);
                left.add(right.pollFirst());
                balance(left,right);

                ret[i-k+1] = getMedian(left,right, k, nums);
            }
            return ret;
        }

        // right size >= left size
        public void balance(TreeSet<Integer> left, TreeSet<Integer> right){
            while(left.size() > right.size()){
                right.add(left.pollFirst());
            }
        }

        public double getMedian(TreeSet<Integer> left, TreeSet<Integer> right, int k, int[] nums){
            return k % 2 == 0 ? ((double)nums[left.first()] + nums[right.first()])/2 : (double)nums[right.first()];
        }
    }
}
