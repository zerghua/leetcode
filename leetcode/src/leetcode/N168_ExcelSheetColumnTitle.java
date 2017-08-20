package leetcode;
/*

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB

 */
public class N168_ExcelSheetColumnTitle {
	// Microsoft, Facebook
    // convert base 10 to base 26
    // construct from right to left, use mod first then divide. n-- to solve non-zero issue.
    // 18 / 18 test cases passed.  on 8/20/2017
    // 0 ms
	class Solution {
		public String convertToTitle(int n) {
			String ret="";
			while(n>0){
				n--;
				int val = n%26;
				ret = String.valueOf(Character.toChars('A' + val)) + ret;
				n /=26;
			}
			return ret;
		}
	}


    public static void main(String[] args) {	
    	System.out.println("hua");
    }
    
}
