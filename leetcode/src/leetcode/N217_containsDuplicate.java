package leetcode;
import java.util.HashSet;

//400 ms 93%
public class N217_containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
    	HashSet<Integer> hs = new HashSet<Integer>();
    	for(int i=0; i<nums.length; i++){
    		if(hs.contains(nums[i])) return true;
    		
    		hs.add(nums[i]);
    	}	
        return false;
    }
}
