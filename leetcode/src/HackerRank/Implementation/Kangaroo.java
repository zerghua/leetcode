package HackerRank.Implementation;

import java.util.*;

/**
 * Created by HuaZ on 10/10/2017.

 There are two kangaroos on a number line ready to jump in the positive direction
 (i.e, toward positive infinity). The first kangaroo starts at location and moves at a rate of meters per jump.
 The second kangaroo starts at location and moves at a rate of meters per jump. Given the starting locations
 and movement rates for each kangaroo, can you determine if they'll ever land at the same location at the same time?

 Input Format

 A single line of four space-separated integers denoting the respective values of , , , and .

 Constraints
 0 < x1 < x2 <= 10000
 1 <= v1 <= 10000
 1 <= v2 <= 10000

 Output Format

 Print YES if they can land on the same location at the same time; otherwise, print NO.

 Note: The two kangaroos must land at the same location after making the same number of jumps.

 Sample Input 0

 0 3 4 2

 Sample Output 0

 YES

 Explanation 0

 The two kangaroos jump through the following sequence of locations:

 Thus, the kangaroos meet after jumps and we print YES.

 Sample Input 1

 0 2 5 3

 Sample Output 1

 NO

 Explanation 1

 The second kangaroo has a starting location that is ahead (further to the right) of the first kangaroo's
 starting location (i.e., ). Because the second kangaroo moves at a faster rate (meaning ) and is already
 ahead of the first kangaroo, the first kangaroo will never be able to catch up. Thus, we print NO.

 */
public class Kangaroo {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
        if(v2 >= v1) return "NO";
        while(x1 <= x2){
            if(x1 == x2) return "YES";
            x1 += v1;
            x2 += v2;
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
