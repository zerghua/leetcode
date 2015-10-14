package leetcode;
import java.util.*;
//[-2147483648,-2147483647,2147483647]
//Given a sorted integer array without duplicates, return the summary of its ranges.
//For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

// 1 ms
public class N228_SummaryRanges {
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
}
