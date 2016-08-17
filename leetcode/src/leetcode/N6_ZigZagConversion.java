package leetcode;

/**
 * Created by Hua on 5/23/2016.

 The string "PAYPALISHIRING" is written in a zigzag pattern
 on a given number of rows like this: (you may want to display
 this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R

 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);

 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 */
public class N6_ZigZagConversion {
    //7 ms
    //math formula.
    public String convert(String s, int numRows) {
        if(s==null|| s.length()==0 || numRows<=0) return "";
        if(numRows == 1) return s;

        int size = 2*numRows - 2;  //formula.
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=i;j<s.length();j+=size){
                sb.append(s.charAt(j));
                if(i!=0 && i!=numRows-1 && j+size-2*i < s.length()){
                    sb.append(s.charAt(j+size-2*i)); //formula
                }
            }
        }
        return sb.toString();
    }

    // follow the pattern, use offset number to update position
    // 10 ms
    public String convert2(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) sb[i] = new StringBuilder();

        int index=0, offset=1;
        for(char c: s.toCharArray()){
            sb[index].append(c);
            if(index == 0) offset = 1;
            else if(index == numRows-1) offset = -1;
            index += offset;
        }

        StringBuilder ret = new StringBuilder();
        for(int i=0;i<numRows;i++) ret.append(sb[i]);
        return ret.toString();
    }


}
