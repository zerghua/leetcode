package HackerRank.Implementation;

import java.util.*;

/**
 * Created by HuaZ on 10/11/2017.
 */
public class MigratoryBirds {
    // most common item
    // counting sort with 5 categories
    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        int[] count = new int[6];
        for(int e : ar) count[e]++;
        int max=count[5], ret = 5;
        for(int i=4; i>0 ; i--){
            if(count[i] >= max){
                max = count[i];
                ret = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
