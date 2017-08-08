package leetcode;

/**
 * Created by Hua on 7/18/2017.

 Implement an iterator to flatten a 2d vector.

 For example,
 Given 2d vector =

 [
     [1,2],
     [3],
     [4,5,6]
 ]

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

 Follow up:
 As an added challenge, try to code it using only iterators in C++ or iterators in Java.

 */

import java.util.*;
public class N251_Flatten2DVector {
    // Google, Airbnb
    // 17 / 17 test cases passed.
    // 4 ms
    // iterator design
    public class Vector2D implements Iterator<Integer> {
        Iterator<List<Integer>> i;
        Iterator<Integer> j;

        public Vector2D(List<List<Integer>> vec2d) {
            i = vec2d.iterator();
        }

        @Override
        public Integer next() {
            hasNext();
            return j.next();
        }

        @Override
        public boolean hasNext() {
            while((j == null || !j.hasNext()) && i.hasNext()) j = i.next().iterator();
            return j != null && j.hasNext();
        }
    }
}
