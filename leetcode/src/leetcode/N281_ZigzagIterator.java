package leetcode;

/**
 * Created by Hua on 7/14/2017.

 Given two 1d vectors, implement an iterator to return their elements alternately.

 For example, given two 1d vectors:

 v1 = [1, 2]
 v2 = [3, 4, 5, 6]

 By calling next repeatedly until hasNext returns false, the order of elements returned
 by next should be: [1, 3, 2, 4, 5, 6].

 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

 Clarification for the follow up question - Update (2015-09-18):
 The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you,
 replace "Zigzag" with "Cyclic". For example, given the following input:

 [1,2,3]
 [4,5,6,7]
 [8,9]

 It should return [1,4,8,2,5,9,3,6,7].


 */
import java.util.*;
public class N281_ZigzagIterator {
    // Google (Premium)
    // o(1) space which can handle k lists
    // 125 / 125 test cases passed.
    // 6 ms
    public class ZigzagIterator2 {
        LinkedList<Iterator> list;
        public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
            list = new LinkedList<Iterator>();
            if(!v1.isEmpty()) list.add(v1.iterator());
            if(!v2.isEmpty()) list.add(v2.iterator());
        }

        public int next() {
            Iterator poll = list.removeFirst();
            int result = (Integer)poll.next();
            if(poll.hasNext()) list.add(poll);
            return result;
        }

        public boolean hasNext() {
            return !list.isEmpty();
        }
    }


    // 125 / 125 test cases passed.
    // 3 ms
    // o(n) space
    public class ZigzagIterator {
        int p1, p2;
        List<Integer> l1;
        List<Integer> l2;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            p1 = 0;
            p2 = 0;
            l1 = v1;
            l2 = v2;
        }

        public int next() {
            if(hasNext()){
                if((p1 == p2 && p1 < l1.size()) || p2 >= l2.size()){
                    return l1.get(p1++);
                }else{
                    return l2.get(p2++);
                }
            }
            return 0;
        }

        public boolean hasNext() {
            if(p1 < l1.size() || p2 < l2.size()) return true;
            return false;
        }
    }




}
