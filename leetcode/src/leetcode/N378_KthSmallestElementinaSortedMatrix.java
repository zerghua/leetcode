package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Hua on 8/26/16.

 Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ n^2.



 */
public class N378_KthSmallestElementinaSortedMatrix {
    // Google, Twitter
    // 36 ms heap
    public class Pair implements Comparable<Pair>{
        int x, y,val;
        public Pair(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }


    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for(int i=0;i<n;i++) minHeap.add(new Pair(0,i, matrix[0][i])); // add first row

        for(int i=0;i<k-1;i++){
            Pair p = minHeap.poll();
            if(p.x == n-1) continue;
            minHeap.add(new Pair(p.x+1, p.y, matrix[p.x+1][p.y]));
        }
        return minHeap.poll().val;
    }
}
