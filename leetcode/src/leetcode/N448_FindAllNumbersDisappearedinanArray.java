package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuaZ on 11/21/2016.

 Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime?
 You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]

 https://discuss.leetcode.com/topic/67192/java-o-n-1-ms-easy-to-understand-with-explanation

 take example:
 [2,1,1,4]
 [2,1,1,2]
 [4,3,2,1]

 */
public class N448_FindAllNumbersDisappearedinanArray {
    // Google
    // 1 ms 4 / 4 test cases passed.
    // o(1) space tricky solution.
    // o(n) space solution use counting sort or hashtable.
    public class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for(int i=0;i<nums.length;i++){
                int index = Math.abs(nums[i]) - 1; //Math.abs are important
                nums[index] = nums[index] > 0 ? -nums[index] : nums[index];
            }

            List<Integer> ret = new ArrayList();
            for(int i=0;i<nums.length;i++){
                if(nums[i] >0) ret.add(i+1);
            }
            return ret;
        }
    }
}
