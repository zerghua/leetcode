package HackerRank.Implementation;

import java.util.*;

/**
 * Created by HuaZ on 10/11/2017.
 */
public class BirthdayChocolate {
    // fixed sliding window
    // window m sums to d
    static int solve(int n, int[] s, int d, int m){
        // Complete this function
        if(s.length < m) return 0;
        int ret = 0, sum=0;
        for(int i=0; i<s.length; i++){
            sum += s[i];
            if(i >= m) sum -= s[i-m];
            if(i >= m-1 && sum == d) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
