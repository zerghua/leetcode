package HackerRank.Implementation;

import java.util.*;

/**
 * Created by HuaZ on 10/10/2017.
 */
public class BetweenTwoSets {
    static int getTotalX(int[] a, int[] b) {
        // Complete this function
        int min = a[0], max = b[0];
        for(int i : a) min = Math.max(min, i);
        for(int i : b) max = Math.min(max, i);

        int ret =0;
        for(int i = min; i<= max ; i++){
            boolean isFound = true;
            for(int j : b) if(j % i != 0) {
                isFound = false;
                break;
            }

            for(int j : a) if(i % j != 0){
                isFound = false;
                break;
            }
            if(isFound) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
