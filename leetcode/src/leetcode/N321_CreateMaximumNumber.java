package leetcode;

/**
 * Created by Hua on 6/6/2017.

 Given two arrays of length m and n with digits 0-9 representing two numbers.
 Create the maximum number of length k <= m + n from digits of the two.
 The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 You should try to optimize your time and space complexity.

 Example 1:

 nums1 = [3, 4, 6, 5]
 nums2 = [9, 1, 2, 5, 8, 3]
 k = 5
 return [9, 8, 6, 5, 3]

 Example 2:

 nums1 = [6, 7]
 nums2 = [6, 0, 4]
 k = 5
 return [6, 7, 6, 0, 4]

 Example 3:

 nums1 = [3, 9]
 nums2 = [8, 9]
 k = 3
 return [9, 8, 9]

 In short we can first solve 2 simpler problem

 Create the maximum number of one array with size k.(itself is a medium question)
 Create the maximum number of two array using all of their digits.

 */
public class N321_CreateMaximumNumber {
    // tricky problem(lots of potential bugs and hard to write correct code), array
    // 102 / 102 test cases passed.
    // 20 ms
    public class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            int[] ret = new int[k];
            for(int i=Math.max(0, k - m); i<= Math.min(k, n); i++){ // choose x,y(x+y==k) from each array
                int[] candidate = merge(maxArray(nums1, k-i), maxArray(nums2, i));
                if(isGreater(candidate, 0, ret, 0)) ret = candidate;
            }
            return ret;
        }

        // This is a medium question
        // get the max array by choosing k items
        public int[] maxArray(int[] num, int k){
            int n = num.length, j =0;
            int[] ret = new int[k];
            for(int i=0; i<n; i++){
                while(j>0 && n + j - i > k && ret[j-1] < num[i]) j-- ; // put the larger one in higher position
                if(j < k) ret[j++] = num[i];  // if(j < k) makes sure it won't go out when array is decreasing.
            }
            return ret;
        }

        // tricky, example like [6, 7] and [6, 0, 4], should use isGreater function to decide which to go first.
        public int[] merge(int[] nums1, int[] nums2){
            int m = nums1.length, n = nums2.length, k = m + n, i = 0, j =0, p = 0;
            int[] ret = new int[k];
            while(p < k) ret[p++] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
            return ret;
        }

        // tricky might easily get wrong, the second if is important
        public boolean isGreater(int[] candidate, int i, int[] ret, int j){
            for(; i< candidate.length && j < ret.length; i++, j++){
                if(candidate[i] > ret[j]) return true;
                if(candidate[i] < ret[j]) return false;
            }
            return i != candidate.length;
        }
    }
}
