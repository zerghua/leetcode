package HackerRank.Implementation;

import java.util.*;

/**
 * Created by HuaZ on 10/11/2017.
 */
public class DivisibleSumPairs {
    // o(n^2) BF?
    static int divisibleSumPairs(int n, int k, int[] ar) {
        // Complete this function
        int ret =0;
        for(int i=0; i<ar.length; i++){
            for(int j=i+1;j<ar.length;j++){
                if((ar[i] + ar[j]) % k == 0) ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }
}
