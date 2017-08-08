package leetcode;

/**
 * Created by Hua on 6/22/2017.

 Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array
 that can make triangles if we take them as side lengths of a triangle.

 Example 1:

 Input: [2,2,3,4]
 Output: 3
 Explanation:
 Valid combinations are:
 2,3,4 (using the first 2)
 2,3,4 (using the second 2)
 2,2,3

 Note:

 The length of the given array won't exceed 1000.
 The integers in the given array are in the range of [0, 1000].

 */

import java.util.*;
public class N611_ValidTriangleNumber {
    // Expedia
    // time o(logN * n^2) treemap + sort + 2 loops.
    // 220 / 220 test cases passed.
    // 125 ms
    public class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            TreeMap<Integer, LinkedList<Integer>> map = new TreeMap();
            for(int i=0;i<nums.length; i++){
                if(!map.containsKey(nums[i])) map.put(nums[i], new LinkedList());
                map.get(nums[i]).add(i);
            }

            int ret = 0;
            for(int i=0; i<nums.length; i++){
                for(int j=i+1; j<nums.length; j++){
                    int sum = nums[i] + nums[j];
                    Integer key = map.lowerKey(sum);
                    if(key != null) ret += Math.max(0, map.get(key).getLast() - j);
                }
            }
            return ret;
        }
    }

    // o(n^2) two pointers + right to left
    // 220 / 220 test cases passed.
    // 30 ms
    public class Solution2 {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int ret = 0;
            for(int i=nums.length-1; i>=0; i--){
                int l = 0, r = i-1;
                while(l < r){
                    if(nums[l] + nums[r] > nums[i]){
                        ret += r - l;
                        r--;
                    }else l++;
                }
            }
            return ret;
        }
    }

}
