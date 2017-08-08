package leetcode;

/**
 * Created by HuaZ on 10/24/2016.

 Given a non-empty array of integers, return the third maximum number in this array.
 If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:

 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.

 Example 2:

 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

 Example 3:

 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.

 */
public class N414_ThirdMaximumNumber {
    // Amazon
    // assume the max of array is fairly large, so we can't do counting sort.
    // array is non-empty by given
    // no information on if the array contains negative, should clarify that.
    // requirement 1, return max if third max can't be find. (2,3,2) return 3, very tricky to solve
    // requirement 2, return distinct third max. (3,2,2,1) return 1

    // 8 ms 26 / 26 test cases passed.
    public class Solution {
        public int thirdMax(int[] nums) {
            Integer first, second, third;
            first = second = third = null;
            for(int n : nums){
                if( (first != null && first == n) || (second!= null && second == n) ||
                        (third!=null && third == n)) continue;  //to skip duplicate
                if(first == null || n > first){
                    third = second; second = first; first = n;
                }else if(second == null || n > second ){
                    third = second; second = n;
                }else if(third == null || n > third){
                    third = n;
                }
            }
            return third == null? first : third;
        }
    }
}
