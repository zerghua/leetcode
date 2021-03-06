package leetcode;

/**
 * Created by Hua on 5/30/2016.

 Follow up for H-Index: What if the citations array is sorted in ascending order?
 Could you optimize your algorithm?

 Hint:

 Expected runtime complexity is in O(log n) and the input is sorted.

take example:
 0 1 3 5 6
 0 1 2 5 6
 0 1 4 5 6

 */
public class N275_HIndex2 {
    // Facebook
    // binary search
    // 13 ms
    public int hIndex(int[] citations) {
        if(citations ==null || citations.length==0) return 0;
        int n = citations.length ;
        int left=0, right=n-1;
        while(left<=right){
            int mid = (right-left)/2 + left;
            if(citations[mid] ==  n - mid) return n-mid;
            else if(citations[mid] < n -mid) left = mid+1;
            else right = mid-1;
        }
        return n-left;
    }
}
