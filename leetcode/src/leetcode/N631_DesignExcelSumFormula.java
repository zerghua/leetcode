package leetcode;

/**
 * Created by Hua on 6/30/2017.

 Your task is to design the basic function of Excel and implement the function of sum formula. Specifically,
 you need to implement the following functions:

 Excel(int H, char W): This is the constructor. The inputs represents the height and width of the Excel form.
 H is a positive integer, range from 1 to 26. It represents the height. W is a character range from 'A' to 'Z'.
 It represents that the width is the number of characters from 'A' to W. The Excel form content is represented
 by a height * width 2D integer array C, it should be initialized to zero.
 You should assume that the first row of C starts from 1, and the first column of C starts from 'A'.


 void Set(int row, char column, int val): Change the value at C(row, column) to be val.

 int Get(int row, char column): Return the value at C(row, column).

 int Sum(int row, char column, List of Strings : numbers): This function calculate and set the value at C(row, column),
 where the value should be the sum of cells represented by numbers.
 This function return the sum result at C(row, column). This sum formula should exist until this cell is overlapped
 by another value or another sum formula.

 numbers is a list of strings that each string represent a cell or a range of cells. If the string represent
 a single cell, then it has the following format : ColRow. For example, "F7" represents the cell at (7, F).

 If the string represent a range of cells, then it has the following format : ColRow1:ColRow2. The range will
 always be a rectangle, and ColRow1 represent the position of the top-left cell,
 and ColRow2 represents the position of the bottom-right cell.


 Example 1:

 Excel(3,"C");
 // construct a 3*3 2D array with all zero.
 //   A B C
 // 1 0 0 0
 // 2 0 0 0
 // 3 0 0 0

 Set(1, "A", 2);
 // set C(1,"A") to be 2.
 //   A B C
 // 1 2 0 0
 // 2 0 0 0
 // 3 0 0 0

 Sum(3, "C", ["A1", "A1:B2"]);
 // set C(3,"C") to be the sum of value at C(1,"A") and the values sum of the rectangle range whose top-left cell is
 C(1,"A") and bottom-right cell is C(2,"B"). Return 4.
 //   A B C
 // 1 2 0 0
 // 2 0 0 0
 // 3 0 0 4

 Set(2, "B", 2);
 // set C(2,"B") to be 2. Note C(3, "C") should also be changed.
 //   A B C
 // 1 2 0 0
 // 2 0 2 0
 // 3 0 0 6

 Note:

 You could assume that there won't be any circular sum reference. For example, A1 = sum(B1) and B1 = sum(A1).
 The test cases are using double-quotes to represent a character.
 Please remember to RESET your class variables declared in class Excel, as static/class variables are persisted
 across multiple test cases. Please see here for more details.

 */

import java.util.*;
public class N631_DesignExcelSumFormula {
    // Microsoft
    // recursive update
    // 20 / 20 test cases passed.
    // 124 ms
    public class Excel {
        HashMap<String, HashMap<String, Integer>> map; // contains the sum info
        int[][] a;

        public Excel(int H, char W) {
            map = new HashMap();
            a = new int[26][26];  // 0-based array
        }


        public void set(int r, char c, int v) {
            String key = c + "" + r;
            if(map.containsKey(key)) map.remove(key);
            a[r - 1][c - 'A'] = v;
            update(map, key);  // important, recursively udpate
        }

        private void update(HashMap<String, HashMap<String, Integer>> map, String key){
            for(String k : map.keySet()){
                if(map.get(k).containsKey(key)){
                    // recalculate sum
                    int sum = 0;
                    for(String s: map.get(k).keySet()){
                        sum += map.get(k).get(s) * get(Integer.parseInt(s.substring(1)), s.charAt(0));
                    }
                    a[Integer.parseInt(k.substring(1)) - 1][k.charAt(0) - 'A'] = sum;
                    update(map, k);
                }
            }
        }


        public int get(int r, char c) {
            return a[r - 1][c - 'A'];
        }

        public int sum(int r, char c, String[] strs) {
            String key = c + "" + r;
            int sum = 0;
            HashMap<String, Integer> sumMap = new HashMap();
            for(String s: strs){
                if(s.length() <=3 ){
                    sum += a[Integer.parseInt(s.substring(1)) - 1][s.charAt(0) - 'A'];
                    if(!sumMap.containsKey(s)) sumMap.put(s, 1);
                    else sumMap.put(s, sumMap.get(s) + 1);
                }else{
                    String[] split = s.split(":");
                    int top  = Integer.parseInt(split[0].substring(1)) - 1, bottom = Integer.parseInt(split[1].substring(1)) - 1;
                    int left = split[0].charAt(0) - 'A',                    right =  split[1].charAt(0) - 'A';
                    for(int i=top; i<=bottom; i++){
                        for(int j=left; j<=right; j++){
                            sum += a[i][j];

                            String k = (char)(j + 'A') + "" + (i+1);
                            if(!sumMap.containsKey(k)) sumMap.put(k, 1);
                            else sumMap.put(k, sumMap.get(k) + 1);
                        }
                    }
                }
            }
            map.put(key, sumMap);
            a[r - 1][c - 'A'] = sum;
            return sum;
        }
    }
}
