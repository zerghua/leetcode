package leetcode;

/**
 * Created by HuaZ on 9/4/2017.

 1
 1 1
 1 2 1
 1 3 3 1
 1 4 6 4 1
 1 5 10 10 5 1

 */
public class A_PascalTriangle {
    public void genTriangle(int n){
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0;j<=i;j++){
                if(j == 0 || i == j) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        print(dp);
    }

    public void genTriangle1D(int n){
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            for(int j=i;j>=0;j--){
                if(j == 0 || i == j) dp[j] = 1;
                else dp[j] += dp[j-1];
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }

    }

    public void print(int[][] a){
        for(int i=0; i<a.length;i++){
            for(int j=0; j<a[0].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        //new A_PascalTriangle().genTriangle(5);
        new A_PascalTriangle().genTriangle1D(5);
    }
}
