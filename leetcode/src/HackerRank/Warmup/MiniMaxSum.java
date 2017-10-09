package HackerRank.Warmup;

import java.util.*;

/**
 * Created by HuaZ on 10/8/2017.

 Given five positive integers, find the minimum and maximum values that can be calculated
 by summing exactly four of the five integers. Then print the respective minimum and maximum values
 as a single line of two space-separated long integers.

 Input Format

 A single line of five space-separated integers.

 Constraints

 Each integer is in the inclusive range .

 Output Format

 Print two space-separated long integers denoting the respective minimum and maximum values
 that can be calculated by summing exactly four of the five integers. (The output can be greater than 32 bit integer.)

 Sample Input

 1 2 3 4 5

 Sample Output

 10 14

 Explanation

 Our initial numbers are , , , , and . We can calculate the following sums using four of the five integers:

 If we sum everything except , our sum is .
 If we sum everything except , our sum is .
 If we sum everything except , our sum is .
 If we sum everything except , our sum is .
 If we sum everything except , our sum is .

 As you can see, the minimal sum is and the maximal sum is .
 Thus, we print these minimal and maximal sums as two space-separated integers on a new line.

 Hints: Beware of integer overflow! Use 64-bit Integer.

 */
public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        int min=Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        long sum=0;
        for(int i : arr){
            sum += i;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        System.out.println((sum - max) + " " + (sum - min));
    }
}
