package leetcode;

/**
 * Created by Hua on 6/26/2017.

 Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.

 If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.

 Example 1
 Input:

 48

 Output:

 68

 Example 2
 Input:

 15

 Output:

 35


 */
public class N625_MinimumFactorization {
    // Tencent
    // math
    // 146 / 146 test cases passed.
    // 10 ms
    public class Solution {
        public int smallestFactorization(int a) {
            if(a == 1) return 1;
            int[] nums = {2,3,4,5,6,7,8,9};
            int[] count = new int[nums.length]; // store count of divider

            int total_digit=0, ret =0;
            for(int i=nums.length-1; i>=0; i--){
                while(a % nums[i] == 0){
                    count[i]++;
                    a /= nums[i];
                    total_digit++;
                }
            }
            if(a > 9 || total_digit >=10) return 0;   // Integer.MAX_VALUE is 2,147,483,647

            for(int i=0; i<count.length; i++){
                while(count[i] != 0){
                    ret = ret*10 + nums[i];
                    count[i]--;
                }
            }
            return ret;
        }
    }
}
