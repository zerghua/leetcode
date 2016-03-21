package leetcode;

/**
 * Created by Hua on 3/21/2016.
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
