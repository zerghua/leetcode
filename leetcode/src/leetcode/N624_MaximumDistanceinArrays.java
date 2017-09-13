package leetcode;

/**
 * Created by Hua on 6/26/2017.

 Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different
 arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be
 their absolute difference |a-b|. Your task is to find the maximum distance.

 Example 1:

 Input:
 [[1,2,3],
 [4,5],
 [1,2,3]]
 Output: 4
 Explanation:
 One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.

 Note:

 Each given array will have at least 1 number. There will be at least two non-empty arrays.
 The total number of the integers in all the m arrays will be in the range of [2, 10000].
 The integers in the m arrays will be in the range of [-10000, 10000].


 */

import java.util.*;
public class N624_MaximumDistanceinArrays {
    // Yahoo (Premium)
    // o(2*n), two loops(left->right and right->left)
    // 124 / 124 test cases passed.
    // 35 ms
    public class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            int n = arrays.size(), ret = 0;
            // left -> right
            int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size()-1);
            for(int i=1;i<n; i++){
                ret = Math.max(ret, max - arrays.get(i).get(0));
                ret = Math.max(ret, arrays.get(i).get(arrays.get(i).size()-1) - min);
                min = Math.min(min, arrays.get(i).get(0));
                max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
            }

            // right->left
            min = arrays.get(n-1).get(0); max = arrays.get(n-1).get(arrays.get(n-1).size()-1);
            for(int i=n-2;i>=0; i--){
                ret = Math.max(ret, max - arrays.get(i).get(0));
                ret = Math.max(ret, arrays.get(i).get(arrays.get(i).size()-1) - min);
                min = Math.min(min, arrays.get(i).get(0));
                max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
            }
            return ret;
        }
    }


    // second loop is not necessary
    // 124 / 124 test cases passed.
    // 20 ms
    public class Solution2 {
        public int maxDistance(List<List<Integer>> arrays) {
            int n = arrays.size(), ret = 0;
            // left -> right
            int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size()-1);
            for(int i=1;i<n; i++){
                ret = Math.max(ret, max - arrays.get(i).get(0));
                ret = Math.max(ret, arrays.get(i).get(arrays.get(i).size()-1) - min);
                min = Math.min(min, arrays.get(i).get(0));
                max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
            }
            return ret;
        }
    }
}
