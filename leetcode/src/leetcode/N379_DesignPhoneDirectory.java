package leetcode;
import java.util.*;
/**
 * Created by HuaZ on 10/11/2016.

 Design a Phone Directory which supports the following operations:

 get: Provide a number which is not assigned to anyone.
 check: Check if a number is available or not.
 release: Recycle or release a number.

 Example:

 // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 PhoneDirectory directory = new PhoneDirectory(3);

 // It can return any available phone number. Here we assume it returns 0.
 directory.get();

 // Assume it returns 1.
 directory.get();

 // The number 2 is available, so return true.
 directory.check(2);

 // It returns 2, the only number that is left.
 directory.get();

 // The number 2 is no longer available, so return false.
 directory.check(2);

 // Release number 2 back to the pool.
 directory.release(2);

 // Number 2 is available again, return true.
 directory.check(2);


 */

public class N379_DesignPhoneDirectory {
    // google
    // hashset + linkedlist
    // 18 / 18 test cases passed.  7/21/2017
    // 557 ms
    public class PhoneDirectory {
        int max;
        HashSet<Integer> set;
        LinkedList<Integer> queue;

        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            set = new HashSet<Integer>();
            queue = new LinkedList<Integer>();
            for(int i=0; i<maxNumbers; i++){
                queue.offer(i);
            }
            max=maxNumbers-1;
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            if(queue.isEmpty())  return -1;
            int e = queue.poll();
            set.add(e);
            return e;
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            return !set.contains(number) && number<=max;
        }

        /** Recycle or release a number. */
        public void release(int number) {
            if(set.contains(number)){
                set.remove(number);
                queue.offer(number);
            }
        }
    }
}
