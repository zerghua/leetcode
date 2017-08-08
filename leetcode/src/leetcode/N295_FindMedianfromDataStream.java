package leetcode;

import java.util.PriorityQueue;

/**
 * Created by Hua on 7/31/2016.

 Median is the middle value in an ordered integer list.
 If the size of the list is even, there is no middle value.
 So the median is the mean of the two middle value.
 Examples:

 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream
 to the data structure.
 double findMedian() - Return the median of all elements so far.

 For example:

 add(1)
 add(2)
 findMedian() -> 1.5
 add(3)
 findMedian() -> 2


 */
public class N295_FindMedianfromDataStream {
    // Google
    // 119 ms, 2 heaps, o(nlogn)
    public class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder(){
            minHeap = new PriorityQueue<>((o1, o2) -> o1-o2);
            maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
        }

        // Adds a number into the data structure.
        // sequence should be the exact same.
        public void addNum(int num) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
            if(minHeap.size() < maxHeap.size()) minHeap.add(maxHeap.poll());
        }

        // Returns the median of current data stream
        public double findMedian() {
            if(minHeap.size() == maxHeap.size())
                return minHeap.peek()/2.0 + maxHeap.peek()/2.0;
            return minHeap.peek();
        }
    };


    // BST, might be faster.
    // https://discuss.leetcode.com/topic/40917/18ms-beats-100-java-solution-with-bst

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
}
