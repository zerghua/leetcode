package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Hua on 5/1/2016.
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.

 DP solution:

 example:
    0 0 0 1 0 0 0
    0 0 1 1 1 0 0
    0 1 1 1 1 1 0


 left
 r1:0 0 0 3 0 0 0
 r2:0 0 2 3 2 0 0
 r3:0 1 2 3 2 1 0

 right
 r1:7 7 7 4 7 7 7
 r2:7 7 5 4 5 7 7
 r3:7 6 5 4 5 6 7


max = (right - left) * height


 */
public class N85_MaximalRectangle {
    // Facebook
    // tricky DP, left[n], right[n], height[n]
    // 66 / 66 test cases passed.  on 8/19/2018
    // 9 ms
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if(matrix == null || matrix.length ==0) return  0;
            int m = matrix.length, n= matrix[0].length, max = 0;
            int[] left = new int[n], right = new int[n], height = new int[n];
            Arrays.fill(right, n);
            for(int i=0; i<m; i++){
                int cur_left = 0, cur_right=n;
                for(int j=0;j<n; j++){  //left[]
                    if(matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                    else{left[j] = 0; cur_left = j+1;}
                }

                for(int j=n-1; j>=0; j--){ //right[]
                    if(matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                    else{right[j] = n; cur_right = j;}
                }

                for(int j=0; j<n;j++){ // height[]
                    if(matrix[i][j] == '1') height[j]++;
                    else height[j] = 0;
                }

                for(int j=0; j<n; j++){
                    max = Math.max(max, (right[j] - left[j])*height[j]);
                }
            }
            return max;
        }
    }


    // convert matrix to n rows of histogram
    // and solve it by N84 in o(N)
    // total time o(N^2)
    // 27 ms
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length ==0) return  0;

        // construct n rows of histogram
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] heights = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == '1'){
                    heights[i][j] = (i ==0 ? 1: heights[i-1][j] +1);
                }
            }
        }

        // re-use solution from N84
        int max=0;
        for(int i=0;i<row;i++){
            max = Math.max(max, largestRectangleArea(heights[i]));
        }
        return max;
    }


    // from N84 Largest Rectangle histogram
    public int largestRectangleArea(int[] heights) {
        if(heights ==null || heights.length==0) return 0;
        Stack<Integer> s = new Stack<>();
        int i=0, max=0;
        while(i<heights.length){
            if(s.isEmpty() || heights[i] >= heights[s.peek()]){
                s.push(i);
                i++;
            }else max = getIMax(heights, s, i, max);
        }
        while(!s.isEmpty()) max = getIMax(heights, s, i, max);
        return max;
    }

    public int getIMax(int[] heights, Stack<Integer> s, int i, int max){
        int height = heights[s.pop()];
        int length = s.isEmpty() ? i : i - 1 - s.peek();
        return Math.max(max, height*length);
    }

}
