package leetcode;

/**
 * Created by Hua on 5/13/2016.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class N4_MedianofTwoSortedArrays {
    // Google, Microsoft
    // 5 ms
    // binary search
    // TODO, need to revisit
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if(total%2 == 1) return getKthMedian(nums1, 0, nums2, 0, 1+ total/2);
        else return (getKthMedian(nums1, 0, nums2, 0, 1+ total/2) + getKthMedian(nums1, 0, nums2, 0, total/2))/2.0;
    }

    private double getKthMedian(int[] nums1, int nums1_start, int[] nums2, int nums2_start, int k) {
        if(nums1_start >= nums1.length) return nums2[k+nums2_start-1];
        if(nums2_start >= nums2.length) return nums1[k+nums1_start-1];
        if(k==1) return Math.min(nums1[nums1_start], nums2[nums2_start]);

        int num1_mid_value = nums1_start + k/2 -1 < nums1.length ? nums1[nums1_start + k/2 -1] : Integer.MAX_VALUE;
        int num2_mid_value = nums2_start + k/2 -1 < nums2.length ? nums2[nums2_start + k/2 -1] : Integer.MAX_VALUE;

        if(num1_mid_value < num2_mid_value) return getKthMedian(nums1, nums1_start+ k/2, nums2, nums2_start, k- k/2);
        else  return getKthMedian(nums1, nums1_start, nums2, nums2_start + k/2, k- k/2);
    }
}
