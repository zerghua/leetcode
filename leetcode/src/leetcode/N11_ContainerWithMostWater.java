package leetcode;

/**
 * Created by Hua on 3/18/2016.
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.
 */
public class N11_ContainerWithMostWater {
    //exceed time limit
    public int maxArea(int[] height) {
        int max=1;
        for(int i=0;i<height.length;i++)
            for(int j=i+1;j<height.length;j++){
                int local_max = Math.min(height[i], height[j])*(j-i);
                if( local_max> max ) max = local_max;
            }
        return max;
    }

    // this might have a bug when left and right height are the same.
    public int maxArea2(int[] height) {
        int i=0, j=height.length-1;
        int min_height = 0;
        int max = 0;

        while(i<j){
            min_height = Math.min(height[i], height[j]);

            int local_max = min_height * (j-i);
            if(local_max > max) max = local_max;

            if (min_height == height[i]) i++;
            else j--;
        }

        return max;
    }

    // should be bug free
    // greedy, can also be done in DP, but need extra space.
    // 4 ms
    public int maxArea3(int[] height) {
        int left = 0, right = height.length-1;
        int max = 0;
        while(left < right){
            int min = Math.min(height[right] , height[left]);
            max = Math.max(max,  min * (right-left));

            while(left<right && height[left]<= min) left++;
            while(left<right && height[right]<= min) right--;
        }
        return max;
    }


}
