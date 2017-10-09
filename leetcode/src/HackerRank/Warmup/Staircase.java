package HackerRank.Warmup;

import java.util.*;

/**
 * Created by HuaZ on 10/8/2017.

 onsider a staircase of size n=4:

 #
 ##
 ###
 ####

 Observe that its base and height are both equal to n,
 and the image is drawn using # symbols and spaces. The last line is not preceded by any spaces.

 Write a program that prints a staircase of size .

 Input Format

 A single integer, , denoting the size of the staircase.

 Output Format

 Print a staircase of size using # symbols and spaces.

 Note: The last line must have spaces in it.

 Sample Input

 6

 Sample Output

      #
     ##
    ###
   ####
  #####
 ######

 Explanation

 The staircase is right-aligned, composed of # symbols and spaces, and has a height and width of .

 */
public class Staircase {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(" ");
        int j = n-1;
        while(j >= 0){
            sb.setCharAt(j, '#');
            System.out.println(sb.toString());
            j--;
        }
    }
}
