package leetcode;

/**
 * Created by Hua on 5/4/2017.

 There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature.
 For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 And we defined a friend circle is a group of students who are direct or indirect friends.

 Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith
 and jth students are direct friends with each other, otherwise not. And you have to output the total number of
 friend circles among all the students.

 Example 1:

 Input:
 [[1,1,0],
 [1,1,0],
 [0,0,1]]
 Output: 2
 Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 The 2nd student himself is in a friend circle. So return 2.

 Example 2:

 Input:
 [[1,1,0],
 [1,1,1],
 [0,1,1]]
 Output: 1
 Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.

 Note:

 N is in range [1,200].
 M[i][i] = 1 for all students.
 If M[i][j] = 1, then M[j][i] = 1.

 */
public class N547_FriendCircles {
    // stack overflow for large data set
    public class Solution1 {
        public int findCircleNum(int[][] M) {
            int row = M.length, col = M[0].length, ret = 0;
            boolean[][] isVisited = new boolean[row][col];
            for(int i=0;i<row; i++){
                for(int j=0;j<col; j++){
                    if(M[i][j] == 1 && isVisited[i][j] == false){
                        ret++;
                        dfs(i, j, M, isVisited);
                    }
                }
            }
            return ret;
        }

        public void dfs(int i, int j, int[][] M, boolean[][] isVisited){
            int row = M.length, col = M[0].length;
            if(i < 0 || i>= row || j < 0 || j>= col || isVisited[i][j] || M[i][j] == 0) return;
            isVisited[i][j] = true;
            dfs(i-1, j, M, isVisited);
            dfs(i+1, j, M, isVisited);
            dfs(i, j-1, M, isVisited);
            dfs(i, j+1, M, isVisited);
        }
    }


    // one dimensional array, M is n*n matrix
    // DFS
    // check each row
    // 113 / 113 test cases passed.
    // 13 ms
    public class Solution {
        public int findCircleNum(int[][] M) {
            int n = M.length, ret = 0;
            boolean[] isVisited = new boolean[n];
            for(int i=0; i<n; i++){
                if(!isVisited[i]){
                    ret++;
                    dfs(i, M, isVisited);
                }
            }
            return ret;
        }

        public void dfs(int i, int[][] M, boolean[] isVisited){
            int n = M.length;
            for(int j=0;j<n;j++){
                if(M[i][j] == 1 && !isVisited[j]){
                    isVisited[j] = true;
                    dfs(j, M, isVisited);
                }
            }
        }
    }

}
