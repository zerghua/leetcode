package leetcode;
import java.util.*;
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
