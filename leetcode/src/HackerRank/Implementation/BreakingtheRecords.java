package HackerRank.Implementation;

import java.util.*;

/**
 * Created by HuaZ on 10/11/2017.
 */
public class BreakingtheRecords {
    // increasing and decreasing array
    static int[] getRecord(int[] s){
        // Complete this function
        int min = s[0], max = s[0];
        int a=0, b=0;
        for(int i=1; i<s.length; i++){
            if(s[i] > max) {
                max = s[i];
                a++;
            }

            if(s[i] < min){
                min = s[i];
                b++;
            }
        }

        return new int[]{a,b};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}
