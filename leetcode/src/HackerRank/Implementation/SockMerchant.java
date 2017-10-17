package HackerRank.Implementation;

import java.util.*;

/**
 * Created by HuaZ on 10/11/2017.
 */
public class SockMerchant {
    // simple hashmap, size <= 100
    static int sockMerchant(int n, int[] ar) {
        // Complete this function
        int[] map = new int[103];
        for(int e : ar) map[e]++;
        int ret =0;
        for(int e : map) ret += e/2;
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
