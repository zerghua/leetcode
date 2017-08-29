package leetcode;

/**
 * Created by Hua on 7/17/2017.

 Given a picture consisting of black and white pixels, and a positive integer N, find the number of
 black pixels located at some specific row R and column C that align with all the following rules:

 Row R and column C both contain exactly N black pixels.
 For all rows that have a black pixel at column C, they should be exactly the same as row R

 The picture is represented by a 2D char array consisting of 'B' and 'W',
 which means black and white pixels respectively.

 Example:

 Input:
 [['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'W', 'B', 'W', 'B', 'W']]

 N = 3
 Output: 6
 Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
         0    1    2    3    4    5         column index
 0    [['W', 'B', 'W', 'B', 'B', 'W'],
 1     ['W', 'B', 'W', 'B', 'B', 'W'],
 2     ['W', 'B', 'W', 'B', 'B', 'W'],
 3     ['W', 'W', 'B', 'W', 'B', 'W']]
 row index

 Take 'B' at row R = 0 and column C = 1 as an example:
 Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels.
 Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2.
 They are exactly the same as row R = 0.

 Note:

 The range of width and height of the input 2D array is [1,200].

 */

import java.util.*;
public class N533_LonelyPixelII {
    // Google
    // 118 / 118 test cases passed.
    // 33 ms
    // hashmap, kind of hard to understand the problem definition.
    public class Solution {
        public int findBlackPixel(char[][] picture, int N) {
            if(picture == null || picture.length == 0) return 0;
            int row = picture.length, col = picture[0].length;

            HashMap<String, Integer> map = new HashMap();
            int[] colCount = new int[col];

            // rule 1
            // put each row into a string, add it to map if count of B == N
            // meanwhile count number of B in each column
            for(int i=0; i< row; i++){
                StringBuilder sb = new StringBuilder();
                int rowCount = 0 ;

                for(int j = 0; j< col; j++){
                    sb.append(picture[i][j]);
                    if(picture[i][j] == 'B') {
                        rowCount++;
                        colCount[j]++;
                    }
                }
                if(rowCount == N){
                    String key = sb.toString();
                    if(!map.containsKey(key)) map.put(key, 1);
                    else map.put(key, map.get(key) + 1);
                    System.out.println(key);
                }
            }

            // rule 2
            int ret = 0;
            for(String key : map.keySet()){
                if(map.get(key) == N){
                    for(int j=0; j<col; j++){
                        if(key.charAt(j) == 'B' && colCount[j] == N) ret += N;
                    }
                }
            }
            return ret;
        }
    }

}

