package leetcode;
import java.util.HashMap;

public class N1_twoSums {
	public int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0;i< nums.length; i++){
			if(hm.containsKey(nums[i])){		
				ret[0] = i+1;
				ret[1] = hm.get(nums[i]);
				
				// switch smaller index to first if necessary
				if(ret[0] > ret[1]){
					int tmp = ret[0];
					ret[0] = ret[1];
					ret[1] = tmp;	
				}
				break;
			}
			hm.put(target - nums[i], i+1);
		}
		return ret;
	}
	

}
