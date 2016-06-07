package leetcode;

import java.util.*;

/**
 * Created by Hua on 6/6/2016.

 Given an integer array of size n, find all elements that appear
 more than ? n/3 ? times. The algorithm should run in linear time and in O(1) space.

 Hint:

 How many majority elements could it possibly have?

 */
public class N229_MajorityElement2 {
    // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
    // similar to N169_MajorityElement
    // [0,2] answers
    // 7 ms
    public List<Integer> majorityElement(int[] nums) {
        Integer a =null, b=null;
        int count_a=0, count_b=0;
        for(int i: nums){
            if(a!=null && a == i) count_a++;
            else if(b!=null && b==i) count_b++;
            else if(count_a == 0) {
                a = i; count_a = 1;
            }
            else if(count_b == 0){
                b = i; count_b = 1;
            }
            else{
                count_a--; count_b--;
            }
        }

        count_a = count_b =0;
        List<Integer> ret = new ArrayList<>();
        for(int i: nums){
            if(i == a) count_a++;
            else if(i == b) count_b++; // must use else if, or will get null pointer error
        }

        if(count_a> nums.length/3) ret.add(a);
        if(count_b> nums.length/3) ret.add(b);
        return ret;
    }
}
