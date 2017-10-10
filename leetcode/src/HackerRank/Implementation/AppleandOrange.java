package HackerRank.Implementation;

import java.util.*;

/**
 * Created by HuaZ on 10/9/2017.

 Sam's house has an apple tree and an orange tree that yield an abundance of fruit.
 In the diagram below, the red region denotes his house, where is the start point and is the end point.
 The apple tree is to the left of his house, and the orange tree is to its right.
 You can assume the trees are located on a single point,
 where the apple tree is at point and the orange tree is at point .

 Apple and orange(2).png

 When a fruit falls from its tree, it lands units of distance from its tree of origin along the -axis.
 A negative value of means the fruit fell units to the tree's left, and a positive value of means
 it falls units to the tree's right.

 Given the value of for apples and oranges, can you determine how many apples and oranges
 will fall on Sam's house (i.e., in the inclusive range )? Print the number of apples that fall on Sam's
 house as your first line of output, then print the number of oranges that fall on Sam's house as
 your second line of output.

 Input Format

 The first line contains two space-separated integers denoting the respective values of and .
 The second line contains two space-separated integers denoting the respective values of and .
 The third line contains two space-separated integers denoting the respective values of and .
 The fourth line contains space-separated integers denoting the respective distances that each apple
 falls from point .
 The fifth line contains space-separated integers denoting the respective distances that each orange
 falls from point .

 Constraints

 Output Format

 Print two lines of output:

 On the first line, print the number of apples that fall on Sam's house.
 On the second line, print the number of oranges that fall on Sam's house.

 Sample Input 0

 7 11
 5 15
 3 2
 -2 2 1
 5 -6

 Sample Output 0

 1
 1

 Explanation 0

 The first apple falls at position .
 The second apple falls at position .
 The third apple falls at position .
 The first orange falls at position .
 The second orange falls at position .
 Only one fruit (the second apple) falls within the region between and , so we print as our first line of output.
 Only the second orange falls within the region between and , so we print as our second line of output.

 */
public class AppleandOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }

        int appleCount = 0, orangeCount=0;
        for(int i: apple){
            int dis = a + i;
            if( s<= dis && dis<= t) appleCount++;
        }

        for(int i: orange){
            int dis = b + i;
            if( s<= dis && dis<= t) orangeCount++;
        }

        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
}
