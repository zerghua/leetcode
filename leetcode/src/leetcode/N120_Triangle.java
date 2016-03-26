package leetcode;

import java.util.*;

/**
 * Created by Hua on 3/26/2016.
 */
public class N120_Triangle {
    //use botton-up, don't need to deal with corner cases. 23ms.
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;

        int rows= triangle.size();
        LinkedList<Integer> ret = new LinkedList<>();
        for(int e: triangle.get(rows-1)) ret.add(e);

        for (int i=rows-2;i>=0;i--){
            // for each element in a row
            for(int j=0;j<=i;j++){
                int current_min = triangle.get(i).get(j) + Math.min(ret.get(j), ret.get(j + 1));
                ret.set(j, current_min);

            }
        }

        return ret.get(0);
    }

    //try int[]  4ms,
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null) return 0;

        int rows= triangle.size();
        int[] ret = new int[rows];
        for(int i=0; i<rows;i++) ret[i]= triangle.get(rows-1).get(i);

        for (int i=rows-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                ret[j] = triangle.get(i).get(j) + Math.min(ret[j], ret[j+1]);
            }
        }

        return ret[0];
    }
}
