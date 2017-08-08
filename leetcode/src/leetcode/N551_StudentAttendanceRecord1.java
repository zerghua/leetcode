package leetcode;

/**
 * Created by Hua on 5/4/2017.

 You are given a string representing an attendance record for a student. The record only contains
 the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.

 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:

 Input: "PPALLP"
 Output: True

 Example 2:

 Input: "PPALLL"
 Output: False


 */
public class N551_StudentAttendanceRecord1 {
    // Google
    // simple question
    // 113 / 113 test cases passed.
    // 14 ms
    public class Solution {
        public boolean checkRecord(String s) {
            int a = 0, l = 0;
            for(char c : s.toCharArray()){
                if(c == 'L') l++;
                else {
                    l = 0;
                    if(c == 'A') a++;
                }
                if(a > 1 || l > 2) return false;
            }
            return true;
        }
    }
}
