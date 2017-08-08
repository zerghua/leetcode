package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Hua on 4/15/2016.
 Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.

 */
public class N179_LargestNumber {
    // Works Application
    // 125 ms
    // look at how to implement Comparator
    public String largestNumber(int[] nums) {
        StringBuilder ret = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for(int e: nums) list.add(e);

        //sort desc, a=30, b=3,  330 > 303
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return (""+b+a).compareTo(""+a+b);
            }
        });

        for(int e: list) ret.append(e);

        //solve corner cases, 0, 0 -> 0
        if(ret.charAt(0) == '0') return "0";

        return ret.toString();
    }

    // added on 10/10/2016
    // new way to passing comparator
    // 120 ms 221 / 221 test cases passed.
    public class Solution {
        public String largestNumber(int[] nums) {
            ArrayList<Integer> list = new ArrayList();
            for(int e:nums)list.add(e);
            Collections.sort(list, (a, b)-> (""+b+a).compareTo(""+a+b));
            StringBuilder ret = new StringBuilder();
            for(int e: list) ret.append(e);
            return ret.charAt(0)=='0' ? "0": ret.toString();
        }
    }

}
