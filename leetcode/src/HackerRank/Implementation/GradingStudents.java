package HackerRank.Implementation;

import java.util.*;

/**
 * Created by HuaZ on 10/8/2017.

 HackerLand University has the following grading policy:

 Every student receives a in the inclusive range from to .
 Any less than is a failing grade.

 Sam is a professor at the university and likes to round each student's according to these rules:

 If the difference between the and the next multiple of is less than , round up to the next multiple of .
 If the value of is less than , no rounding occurs as the result will still be a failing grade.

 For example, will be rounded to but will not be rounded because the rounding would result in a number
 that is less than .

 Given the initial value of for each of Sam's students, write code to automate the rounding process.
 For each , round it according to the rules above and print the result on a new line.

 Input Format

 The first line contains a single integer denoting (the number of students).
 Each line of the subsequent lines contains a single integer, , denoting student 's grade.

 Constraints

 Output Format

 For each of the grades, print the rounded grade on a new line.

 Sample Input 0

 4
 73
 67
 38
 33

 Sample Output 0

 75
 67
 40
 33

 Explanation 0

 image

 Student received a , and the next multiple of from is . Since , the student's grade is rounded to .
 Student received a , and the next multiple of from is . Since ,
 the grade will not be modified and the student's final grade is .

 Student received a , and the next multiple of from is . Since , the student's grade will be rounded to .
 Student received a grade below , so the grade will not be modified and the student's final grade is .



 */
public class GradingStudents {
    static int[] solve(int[] grades){
        // Complete this function
        int[] ret = new int[grades.length];
        for(int i=0; i<grades.length; i++){
            if(grades[i] < 38) ret[i] = grades[i];
            else{
                int round = (grades[i]/5 + 1) *5;
                if( round - grades[i] < 3)ret[i] = round;
                else ret[i] = grades[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


    }
}
