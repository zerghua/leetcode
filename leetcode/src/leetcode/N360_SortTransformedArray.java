package leetcode;

/**
 * Created by HuaZ on 7/16/2017.

 Given a sorted array of integers nums and integer values a, b and c.
 Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

 The returned array must be in sorted order.

 Expected time complexity: O(n)

 Example:

 nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

 Result: [3, 9, 15, 33]

 nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

 Result: [-23, -5, 1, 7]

 Key:
 If a >= 0; the smallest number must be at two ends of original array;
 If a < 0; the largest number must be at two ends of original array;

 */
public class N360_SortTransformedArray {
    // google
    // math + two pointers
    // 110 / 110 test cases passed.
    // 1 ms
    public class Solution {
        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            int[] ret = new int[nums.length];
            int i=0, j = nums.length -1;
            int index = (a >= 0)? nums.length - 1 : 0; // key here
            while(i <= j){
                if(a>= 0) ret[index--] = math(nums[i],a,b,c) > math(nums[j],a,b,c) ?
                        math(nums[i++],a,b,c) : math(nums[j--],a,b,c);

                else ret[index++] = math(nums[i],a,b,c) < math(nums[j],a,b,c) ?
                        math(nums[i++],a,b,c) : math(nums[j--],a,b,c);
            }
            return ret;
        }

        public int math(int x, int a, int b, int c){
            return a*x*x + b*x + c;
        }
    }
}
