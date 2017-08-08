package leetcode;

/**
 * Created by HuaZ on 8/23/2016.

 You are given two jugs with capacities x and y litres.
 There is an infinite amount of water supply available.
 You need to determine whether it is possible to measure exactly z litres using these two jugs.

 If z liters of water is measurable, you must have z liters of water contained
 within one or both buckets by the end.

 Operations allowed:

 Fill any of the jugs completely with water.
 Empty any of the jugs.
 Pour water from one jug into another till the other jug is completely full or
 the first jug itself is empty.

 Example 1: (From the famous "Die Hard" example)

 Input: x = 3, y = 5, z = 4
 Output: True

 Example 2:

 Input: x = 2, y = 6, z = 5
 Output: False

https://discuss.leetcode.com/topic/49238/math-solution-java-solution/2

 */
public class N365_WaterandJugProblem {
    // Microsoft
    // math gcd 0ms
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y < z) return false;
        if(x == z || y == z || x+y == z) return true;
        return z % gcd(x,y) == 0;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
}
