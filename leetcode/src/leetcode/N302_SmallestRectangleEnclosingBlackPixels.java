package leetcode;

/**
 * Created by Hua on 7/24/2017.

 An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 The black pixels are connected, i.e., there is only one black region.
 Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels,
 return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

 For example, given the following image:

 [
 "0010",
 "0110",
 "0100"
 ]

 and x = 0, y = 2,

 Return 6.

 */
public class N302_SmallestRectangleEnclosingBlackPixels {
    // google
    // 2d binary search, binary search on rows and cols multiple times, smart concise code
    // BF is searchd all black points and find out left,right,top,bottom
    // DFS is similar to BF, but start from the given point.
    // o(mlogn + nlogm)
    // 111 / 111 test cases passed.
    // 1 ms
    public class Solution {
        public int minArea(char[][] image, int x, int y) {
            int row = image.length, col = (row != 0) ? image[0].length : 0;
            int left = searchColumns(image, 0, y, 0, row, true);
            int right = searchColumns(image, y+1, col, 0, row, false);
            int top = searchRows(image, 0, x, 0, col, true);
            int bottom = searchRows(image, x+1, row, 0, col, false);
            return (right - left) * (bottom - top);
        }

        public int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean isLeft){
            while(i != j){
                int mid = (j - i)/2 + i, k = top;
                while(k < bottom && image[k][mid] == '0')k++;
                if(k < bottom == isLeft) j = mid;
                else i = mid+1;
            }
            return i;
        }

        public int searchRows(char[][] image, int i, int j, int left, int right, boolean isTop){
            while(i != j){
                int mid = (j - i)/2 + i, k = left;
                while(k < right && image[mid][k] == '0')k++;
                if(k < right == isTop) j = mid;
                else i = mid+1;
            }
            return i;
        }
    }

}
