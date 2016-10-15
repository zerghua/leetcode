package leetcode;
import java.util.HashMap;

/*

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.


 */
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

	// concise code added on 10/15/2016
    // 8 ms 16 / 16 test cases passed.
    // hashmap one pass.
	public class Solution {
		public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap();
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(nums[i])){
                    return new int[]{map.get(nums[i]), i};
                }
                map.put(target-nums[i], i);
            }
            throw new IllegalArgumentException("no solution");
		}
	}
}
