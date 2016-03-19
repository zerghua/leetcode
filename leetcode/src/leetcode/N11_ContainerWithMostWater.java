package leetcode;

/**
 * Created by Hua on 3/18/2016.
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
}
