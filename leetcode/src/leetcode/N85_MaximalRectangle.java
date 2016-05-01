package leetcode;

import java.util.Stack;

/**
 * Created by Hua on 5/1/2016.
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.
 */
public class N85_MaximalRectangle {
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
