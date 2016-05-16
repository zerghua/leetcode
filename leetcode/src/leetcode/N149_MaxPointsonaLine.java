package leetcode;

import java.util.HashMap;

/**
 * Created by Hua on 5/16/2016.
 *
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 */
public class N149_MaxPointsonaLine {
    class Point {
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
    }

    //for each point, calculate it's slope with all other points
    //be careful with duplicate and slope == max infinity
    //32 ms, hashtable o(n^2) time
    public int maxPoints(Point[] points) {
        if(points == null || points.length==0) return 0;
        int max = 0;
        HashMap<Double, Integer> hm = new HashMap<>();
        for(int i=0;i<points.length;i++){
            int duplicate = 0;
            int vertical = 0;
            for(int j=0;j<points.length;j++){
                if(points[i].x == points[j].x){
                    if(points[i].y == points[j].y) duplicate++;
                    else vertical++;
                }else{
                    double slope = 1.0*(points[j].y - points[i].y)/(points[j].x - points[i].x);
                    if(hm.containsKey(slope)) hm.put(slope,hm.get(slope)+1);
                    else hm.put(slope,1);
                }
            }
            //update max for each point
            for(Integer count: hm.values()) max = Math.max(max, count+duplicate);
            max = Math.max(max, vertical+duplicate);
            hm.clear();
        }
        return max;
    }
}
