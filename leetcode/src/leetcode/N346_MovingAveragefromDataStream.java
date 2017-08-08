package leetcode;

/**
 * Created by Hua on 7/10/2017.

 Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,

 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3

 */

import java.util.*;
public class N346_MovingAveragefromDataStream {
    // Google
    // 12 / 12 test cases passed.
    // 160 ms
    public class MovingAverage {
        LinkedList<Integer> q;
        int size;
        long sum;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            q = new LinkedList();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            if(size == q.size()) sum -= q.removeFirst();

            sum += val;
            q.add(val);
            return 1.0 * sum / q.size();
        }
    }
}
