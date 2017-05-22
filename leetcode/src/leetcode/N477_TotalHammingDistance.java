package leetcode;

/**
 * Created by Hua on 5/16/2017.

 The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Now your job is to find the total Hamming distance between all pairs of the given numbers.

 Example:

 Input: 4, 14, 2

 Output: 6

 Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 showing the four bits relevant in this case). So the answer will be:
 HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

 Note:

 Elements of the given array are in the range of 0 to 10^9
 Length of the array will not exceed 10^4.


 Suppose that i numbers have a rightmost 0-bit, and j numbers have a 1-bit. Then out of the pairs,
 i * j of them will have 1 in the rightmost bit of the XOR. This is because there are i * j ways to choose one number
 that has a 0-bit and one that has a 1-bit. These bits will therefore contribute i * j towards the total of all the XORs.
 */
public class N477_TotalHammingDistance {
    // BF is o(n^2)
    // this is o(n) solution
    // 47 / 47 test cases passed.
    // 22 ms
    public class Solution {
        public int totalHammingDistance(int[] nums) {
            int ret = 0;
            for(int i=0; i< 32; i++){
                int count = 0;
                for(int num : nums){
                    count += ((num >> i) & 1);
                }
                ret += count * (nums.length - count);
            }
            return ret;
        }
    }

}
