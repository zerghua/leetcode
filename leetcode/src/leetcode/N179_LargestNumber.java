package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Hua on 4/15/2016.
 */
public class N179_LargestNumber {
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
}
