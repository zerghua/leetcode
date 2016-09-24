package leetcode;

/**
 * Created by Hua on 3/21/2016.

 Given an unsorted array return whether an increasing subsequence
 of length 3 exists or not in the array.

 Formally the function should:

 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.

 Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Examples:
 Given [1, 2, 3, 4, 5],
 return true.

 Given [5, 4, 3, 2, 1],
 return false.

 */

// not require to be continuous,
// equal size is avoid 1,1,1,1
public class N334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int x=Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        for(int z : nums){
            if( z <= x) x = z;
            else if(z <= y) y = z;
            else return true;
        }
        return false;
    }
}
