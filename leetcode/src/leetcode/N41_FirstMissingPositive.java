package leetcode;
import java.math.*;
/**
 * Created by Hua on 4/30/2016.
 *  Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
public class N41_FirstMissingPositive {
    // no company
    //1 ms
    // kind of in place bucket sort
    // careful with duplicate numbers.
    // [1,2,3,5]
    // [1,2,3,4]
    public int firstMissingPositive(int[] nums) {
        int i=0, n= nums.length;
        while(i<n){
            if(nums[i] != i+1 && nums[i]>0 && nums[i] <=n && nums[i] != nums[nums[i] -1]){
                // move nums[i] to its position range in [1,n]
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }else i++;
        }

        for(int j=0;j<n;j++){
            if(nums[j] != j+1) return j+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] table = new int[]{2,1};

        N41_FirstMissingPositive x= new N41_FirstMissingPositive();
        x.firstMissingPositive(table);


    }
}
