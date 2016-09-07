package leetcode;
import java.util.*;
/**
 * Created by Hua on 4/12/2016.
 */
/*
Given a matrix of m x n elements (m rows, n columns),
return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5].
 */

public class N54_SpiralMatrix {
    //1 ms
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix == null || matrix.length==0) return ret;
        spiralOrder(matrix, ret, 0, matrix[0].length-1, 0, matrix.length-1);
        return ret;
    }

    public void spiralOrder(int[][] matrix,  List<Integer> ret,
                            int left, int right, int top, int bottom) {
        if(left > right && top > bottom ) return;

        // top
        if(top<=bottom) {
            for(int i=left; i<=right; i++) ret.add(matrix[top][i]);
            top++;
        }

        // right
        if(left<=right) {
            for(int i=top; i<=bottom; i++) ret.add(matrix[i][right]);
            right--;
        }

        // bottom
        if(top<=bottom) {
            for(int i=right; i>=left; i--) ret.add(matrix[bottom][i]);
            bottom--;
        }

        // left
        if(left<=right) {
            for(int i=bottom; i>=top; i--) ret.add(matrix[i][left]);
            left++;
        }

        // recur
        spiralOrder(matrix, ret, left, right, top, bottom);
    }

    // version 2 added on 9/7/2016
    // 4 sides(top, bottom, left and right). ++ or --
    // 1 ms  22 / 22 test cases passed.
    public class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ret = new ArrayList<>();
            if (matrix == null || matrix.length==0) return ret;
            int top = 0, left = 0, bottom = matrix.length-1, right = matrix[0].length-1;
            while(left<= right || top <= bottom){
                // top side
                if(top <= bottom){
                    for(int i=left; i<=right;i++) ret.add(matrix[top][i]);
                    top++;
                }

                // right side
                if(left <= right){
                    for(int i=top;i<=bottom;i++) ret.add(matrix[i][right]);
                    right--;
                }

                // bottom side
                if(top <= bottom){
                    for(int i=right; i>=left;i--) ret.add(matrix[bottom][i]);
                    bottom--;
                }

                // right side
                if(left <= right){
                    for(int i=bottom;i>=top;i--) ret.add(matrix[i][left]);
                    left++;
                }
            }

            return ret;
        }
    }
}
