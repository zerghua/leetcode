package leetcode;

/**
 * Created by Hua on 7/13/2017.

 Given a picture consisting of black and white pixels, find the number of black lonely pixels.

 The picture is represented by a 2D char array consisting of 'B' and 'W',
 which means black and white pixels respectively.

 A black lonely pixel is character 'B' that located at a specific position
 where the same row and same column don't have any other black pixels.

 Example:

 Input:
 [['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

 Output: 3
 Explanation: All the three 'B's are black lonely pixels.

 Note:

 The range of width and height of the input 2D array is [1,500].

 */

import java.util.*;
public class N531_LonelyPixelI {
    // Google (Premium)
    // 57 / 57 test cases passed.
    // 57 ms
    // hashmap o(n) time
    public class Solution {
        public int findLonelyPixel(char[][] picture) {
            HashMap<Integer, Integer> row = new HashMap();
            HashMap<Integer, Integer> col = new HashMap();
            ArrayList<int[]> list = new ArrayList();
            for(int i=0; i< picture.length; i++){
                for(int j=0; j<picture[0].length; j++){
                    if(picture[i][j] == 'B'){
                        list.add(new int[]{i, j});
                        if(!row.containsKey(i)) row.put(i, 1);
                        else row.put(i, row.get(i)+1);

                        if(!col.containsKey(j)) col.put(j, 1);
                        else col.put(j, col.get(j)+1);
                    }
                }
            }
            int ret = 0;
            for(int[] point: list){
                if(row.get(point[0]) == 1 && col.get(point[1]) == 1) ret++;
            }
            return ret;
        }
    }

    // faster code without using hashmap but array.
    // 57 / 57 test cases passed.
    // 29 ms
    public class Solution2 {
        public int findLonelyPixel(char[][] picture) {
            int n = picture.length, m = picture[0].length;

            int[] rowCount = new int[n], colCount = new int[m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (picture[i][j] == 'B') {
                        rowCount[i]++;
                        colCount[j]++;
                    }

            int count = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) count++;

            return count;
        }
    }
}
