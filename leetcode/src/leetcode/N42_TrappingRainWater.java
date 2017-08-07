package leetcode;
import java.util.*;
import java.util.regex.Matcher;

/**
 * Created by Hua on 4/19/2016.

 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 */
public class N42_TrappingRainWater {
    // Google, Amazon
    // 2 ms
    // kind of DP, keep track of leftmost and rightmost height at i,
    // the water will be trapped at i= min(leftmost[i], rightmost[i]) - height[i]
    public int trap2(int[] height){
        if(height ==null || height.length<=2) return 0;
        int[] leftMostHeight = new int[height.length];
        for(int i=1; i<height.length;i++){
            leftMostHeight[i] = Math.max(leftMostHeight[i-1], height[i-1]);
        }

        int ret = 0;
        int[] rightMostHeight = new int[height.length];
        for(int i=height.length-2; i>0; i--){
            rightMostHeight[i] = Math.max(rightMostHeight[i+1], height[i+1]);
            int waterTrappedAtI= Math.min(leftMostHeight[i], rightMostHeight[i]) - height[i];
            ret += Math.max(waterTrappedAtI, 0);
        }
        return ret;
    }


    //TLE, not right
    public int trap(int[] height) {
        if(height ==null || height.length<=1) return 0;
        List<Integer> tops = new ArrayList<>();
        //first one
        if(height[0] >= height[1]) tops.add(0);
        for(int i=1; i<height.length-1;i++){
            if(height[i] >= height[i-1] && height[i] > height[i+1]) tops.add(i);
        }
        // last one
        if(height[height.length-1] >= height[height.length-2]) tops.add(height.length-1);

        int ret = 0;
        for(int i=1; i<tops.size(); i++) ret += getWater(height, tops.get(i-1), tops.get(i));
        return ret;
    }

    public int getWater(int[] height, int start, int end){
        int max = Math.min(height[start], height[end]);
        int sum = 0;
        for(int i=start+1;i<end;i++) sum += Math.max(0, max-height[i]);
        return sum;
    }





}
