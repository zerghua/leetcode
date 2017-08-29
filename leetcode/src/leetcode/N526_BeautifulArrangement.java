package leetcode;

/**
 * Created by Hua on 5/10/2017.

 Suppose you have N integers from 1 to N.
 We define a beautiful arrangement as an array that is constructed by these
 N numbers successfully if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:

 The number at the ith position is divisible by i.
 i is divisible by the number at the ith position.

 Now given N, how many beautiful arrangements can you construct?

 Example 1:

 Input: 2
 Output: 2
 Explanation:

 The first beautiful arrangement is [1, 2]:

 Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

 Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

 The second beautiful arrangement is [2, 1]:

 Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

 Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

 Note:

 N is a positive integer and will not exceed 15.


 */
public class N526_BeautifulArrangement {
    // Google
    // back tracking, a little hard to imagine.
    // 15 / 15 test cases passed.
    // 8 ms
    public class Solution {
        int ret = 0;
        public int countArrangement(int N) {
            if(N == 0) return 0;
            int[] nums = new int[N+1];
            for(int i=0;i<=N;i++) nums[i] = i;
            dfs(nums, N);
            return ret;
        }

        public void dfs(int[] nums, int k){
            if( k == 0){
                ret++;
                return;
            }
            for(int i=k; i>0 ; i--){
                swap(nums, i, k);
                if(nums[k] % k == 0 || k % nums[k] == 0) dfs(nums, k-1);
                swap(nums, i, k);
            }
        }

        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
