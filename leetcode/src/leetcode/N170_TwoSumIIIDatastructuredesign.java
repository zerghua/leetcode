package leetcode;

/**
 * Created by HuaZ on 7/12/2017.

 Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 For example,

 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false


 */

import java.util.*;
public class N170_TwoSumIIIDatastructuredesign {
    // 16 / 16 test cases passed.
    // 248 ms
    public class TwoSum {
        ArrayList<Integer> list;
        HashMap<Integer, Integer> map;

        /** Initialize your data structure here. */
        public TwoSum() {
            list = new ArrayList();
            map = new HashMap();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if(map.containsKey(number)) map.put(number, map.get(number) + 1);
            else {
                map.put(number, 1);
                list.add(number);
            }
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for(int num1 : list){
                int num2 = value - num1;
                if((num1 == num2) && map.get(num1) > 1 || (num1 != num2) && map.containsKey(num2)) return true;
            }
            return false;
        }
    }

    // TLE, o(n) add
    public class TwoSum_TLE {
        ArrayList<Integer> list;
        HashSet<Integer> set;

        /** Initialize your data structure here. */
        public TwoSum_TLE() {
            list = new ArrayList();
            set = new HashSet();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            for(int num : list) set.add(num + number);
            list.add(number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            return set.contains(value);
        }
    }
}
