package leetcode;
import java.util.*;

/**
 * Created by Hua on 4/30/2016.
 *  Given n non-negative integers representing the histogram's bar height
 *  where the width of each bar is 1, find the area of largest rectangle in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.
 */
public class N84_LargestRectangleinHistogram {
    //25 ms, stack, o(N)
    // if(h[i+1] < h[i]) pop stack and calculate area.
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

    //brute force, o(N^2)
    //for each i, calculate area from it's left and right, when both left and right
    //are higher than i.

}
