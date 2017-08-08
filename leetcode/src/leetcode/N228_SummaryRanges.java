package leetcode;
import java.util.*;

/*
 Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].


test case:
[-2147483648,-2147483647,2147483647]
 */


public class N228_SummaryRanges {
    // Google
    // 1 ms
	public String build_string(int start, int end){
        String s;
		if(start == end) s= String.valueOf(start);
		else s = String.valueOf(start) + "->" + String.valueOf(end);		
		return s;
	}
	
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if(nums == null || nums.length ==0) return ret;
        
        if(nums.length==1){
        	ret.add(String.valueOf(nums[0]));
        	return ret;
        }
        
        int start=0;
        for(int i=1; i<nums.length; i++){
        	//if(nums[i] - nums[i-1] > 1 ) { // might be overflow
        	if(nums[i] -  1> nums[i-1] ) {
        		ret.add(build_string(nums[start], nums[i-1]));
        		start = i;
        	}
        }
        //last string needs to be added
        ret.add(build_string(nums[start], nums[nums.length-1]));

        return ret;
    }

    // concise code added on 10/1/2016
    // 0 ms 27 / 27 test cases passed.
    public class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ret = new ArrayList<>();
            int start=0;
            for(int i=1; i<=nums.length;i++){
                if(i == nums.length || nums[i] != nums[i-1]+1){
                    if(i-1 == start) ret.add(""+ nums[i-1]); // case when last one is single.
                    else ret.add(nums[start] + "->" + nums[i-1]);
                    start = i;
                }
            }
            return ret;
        }
    }
}
