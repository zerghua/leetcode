package HackerRank.Warmup;

import java.util.*;

/**
 * Created by HuaZ on 10/8/2017.

 Given an array of integers, calculate which fraction of its elements are positive,
 which fraction of its elements are negative, and which fraction of its elements are zeroes, respectively.
 Print the decimal value of each fraction on a new line.

 Note: This challenge introduces precision problems. The test cases are scaled to six decimal places,
 though answers with absolute error of up to are acceptable.

 Input Format

 The first line contains an integer, , denoting the size of the array.
 The second line contains space-separated integers describing an array of numbers .

 Output Format

 You must print the following lines:

 A decimal representing of the fraction of positive numbers in the array compared to its size.
 A decimal representing of the fraction of negative numbers in the array compared to its size.
 A decimal representing of the fraction of zeroes in the array compared to its size.

 Sample Input

 6
 -4 3 -9 0 4 1

 Sample Output

 0.500000
 0.333333
 0.166667

 Explanation

 There are positive numbers, negative numbers, and zero in the array.
 The respective fractions of positive numbers, negative numbers and zeroes are , and , respectively.

 */
public class PlusMinus {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int pos =0, neg = 0, zero=0;
        for(int i=0; i<n ; i++){
            int num = in.nextInt();
            if(num > 0) pos++;
            else if(num < 0) neg++;
            else zero++;
        }

        System.out.format("%.6f\n", pos * 1.0 / n);
        System.out.format("%.6f\n", neg* 1.0 / n);
        System.out.format("%.6f\n", zero* 1.0 / n);
    }
}
