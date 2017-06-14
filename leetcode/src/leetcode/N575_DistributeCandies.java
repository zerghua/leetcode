package leetcode;

/**
 * Created by Hua on 6/14/2017.

 Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to
 brother and sister. Return the maximum number of kinds of candies the sister could gain.

 Example 1:

 Input: candies = [1,1,2,2,3,3]
 Output: 3
 Explanation:
 There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 The sister has three different kinds of candies.

 Example 2:

 Input: candies = [1,1,2,3]
 Output: 2
 Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 The sister has two different kinds of candies, the brother has only one kind of candies.

 Note:

 The length of the given array is in range [2, 10,000], and will be even.
 The number in given array is in range [-100,000, 100,000].

 */

import java.util.*;
public class N575_DistributeCandies {
    // easy. hashset.
    // 207 / 207 test cases passed.
    // 93 ms
    public class Solution {
        public int distributeCandies(int[] candies) {
            HashSet<Integer> set = new HashSet();
            int mid = candies.length/2, ret = 0;
            for(int i = 0; i<candies.length && set.size()<mid; i++){
                if(!set.contains(candies[i])){
                    set.add(candies[i]);
                    ret++;
                }
            }
            return ret;
        }
    }
}
