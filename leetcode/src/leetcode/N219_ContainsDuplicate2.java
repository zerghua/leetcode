package leetcode;
import java.util.*;

/*
Given an array of integers and an integer k,
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */

public class N219_ContainsDuplicate2 {
	//13 ms
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	if(nums ==null) return false;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++){
    		if(hm.containsKey(nums[i]) && i - hm.get(nums[i]) <= k) return true;
    		hm.put(nums[i], i);
    	}
    	return false;
    }
}
