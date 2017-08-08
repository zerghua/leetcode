package leetcode;

/**
 * Created by Hua on 5/6/2016.
 *
 *  There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.

 What is the minimum candies you must give?
 */
public class N135_Candy {
    // no company
    // 4 ms
    // dp to store candy of each kid has
    // from two ways to make sure kid i has equal or more than kid i-1 and i+1
    public int candy(int[] ratings) {
        if(ratings ==null || ratings.length ==0) return 0;

        int[] candy = new int[ratings.length];
        // make sure each kid get 1 candy
        for(int i=0;i<candy.length;i++) candy[i] = 1;

        // from left to right, make sure kid i has equal or more than kid i-1
        for(int i=1; i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]) candy[i] = candy[i-1]+1;
        }

        // from right to left, make sure kid i has equal or more than kid i+1
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) candy[i] = candy[i+1]+1;
        }

        int ret = 0;
        for(int i=0;i<ratings.length;i++){
            ret += candy[i];
        }
        return ret;
    }
}
