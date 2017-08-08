package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 6/8/2017.

 Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

 You need to return the number of important reverse pairs in the given array.

 Example1:

 Input: [1,3,2,3,1]
 Output: 2

 Example2:

 Input: [2,4,3,5,1]
 Output: 3

 Note:

 The length of the given array will not exceed 50,000.
 All the numbers in the input array are in the range of 32-bit integer.

 */
public class N493_ReversePairs {
    // Google
    // BF is o(n^2)
    // merge sort + two pointers make it o(nlogn)
    // 137 / 137 test cases passed.
    // 89 ms
    public class Solution {
        public int reversePairs(int[] nums) {
            return dfs(nums, 0, nums.length-1);
        }

        public int dfs(int[] nums, int l, int r){
            if(l >= r) return 0;

            int mid = l + (r - l)/2;
            int ret = dfs(nums, l , mid) + dfs(nums, mid+1, r);

            int[] tmp = new int[r - l + 1];
            int i = l, j = mid+1, p = mid+1, k = 0;
            while(i<= mid){
                // two pointers technique
                while(p <= r && nums[i] > 2* (long)nums[p]) p++;
                ret += p - (mid + 1);

                // regular merge
                while(j <= r && nums[i] >= nums[j]) tmp[k++] = nums[j++];
                tmp[k++] = nums[i++];
            }
            // finish up j part
            while(j <= r) tmp[k++] = nums[j++];

            System.arraycopy(tmp, 0, nums, l, tmp.length);
            return ret;
        }
    }


    // shorter code, but slower
    // 137 / 137 test cases passed.
    // 149 ms
    public class Solution_2 {
        public int reversePairs(int[] nums) {
            return dfs(nums, 0, nums.length-1);
        }

        public int dfs(int[] nums, int l, int r){
            if(l >= r) return 0;

            int mid = l + (r - l)/2;
            int ret = dfs(nums, l , mid) + dfs(nums, mid+1, r);

            // two pointers technique, this is linear rather than quadratic
            for(int i=l, p = mid+1; i<=mid; i++){
                while(p <= r && nums[i] > 2* (long)nums[p]) p++;
                ret += p - (mid + 1);
            }

            Arrays.sort(nums,l,r + 1);
            return ret;
        }
    }
}
