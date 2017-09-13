package leetcode;

/**
 * Created by HuaZ on 7/16/2017.

 Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9,
 count the total number of unlock patterns of the Android lock screen,
 which consist of minimum of m keys and maximum n keys.

 Rules for a valid pattern:

 1 .Each pattern must connect at least m keys and at most n keys.
 2. All the keys must be distinct.
 3. If the line connecting two consecutive keys in the pattern passes through any other keys,
    the other keys must have previously selected in the pattern.
 4. No jumps through non selected key is allowed.
 5. The order of keys used matters.

 Explanation:

 | 1 | 2 | 3 |
 | 4 | 5 | 6 |
 | 7 | 8 | 9 |

 Invalid move: 4 - 1 - 3 - 6
 Line 1 - 3 passes through key 2 which had not been selected in the pattern.

 Invalid move: 4 - 1 - 9 - 2
 Line 1 - 9 passes through key 5 which had not been selected in the pattern.

 Valid move: 2 - 4 - 1 - 3 - 6
 Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

 Valid move: 6 - 5 - 4 - 1 - 9 - 2
 Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

 Example:
 Given m = 1, n = 1, return 9.

 */
public class N351_AndroidUnlockPatterns {
    // Google (Premium)
    // not trivia backtracking.
    // 1-8 and 2-9 need no skip, by design of android. This is a question to ask during interview
    // 24 / 24 test cases passed.
    // 13 ms
    public class Solution {
        public int numberOfPatterns(int m, int n) {
            // have a skip table is one key for this problem, used to check if visited or not.
            int[][] skip = new int[10][10]; //number of skip
            skip[1][3] = skip[3][1] = 2;
            skip[3][9] = skip[9][3] = 6;
            skip[7][9] = skip[9][7] = 8;
            skip[1][7] = skip[7][1] = 4;
            skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] =
                    skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;

            int ret = 0;
            boolean[] isVisited = new boolean[10];
            for(int i=m; i<=n;i++){
                ret += dfs(isVisited, skip, 1, i) * 4;  // 1,3,7,9 are symmetric
                ret += dfs(isVisited, skip, 2, i) * 4;  // 2,4,6,8 are symmetric
                ret += dfs(isVisited, skip, 5, i);
            }
            return ret;
        }

        public int dfs(boolean[] isVisited, int[][] skip, int cur, int remain){
            if(remain == 0) return 0;
            if(remain == 1) return 1;

            int ret = 0;
            isVisited[cur] = true;
            for(int i=1 ; i<=9; i++){
                // only visit when i is not visited and (no need to skip or skip number visited)
                if(!isVisited[i] && (skip[cur][i] == 0 || isVisited[skip[cur][i]])){
                    ret += dfs(isVisited, skip, i, remain-1);
                }
            }
            isVisited[cur] = false;
            return ret;
        }
    }
}
