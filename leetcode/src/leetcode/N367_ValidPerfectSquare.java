package leetcode;

/**
 * Created by Hua on 8/6/16.

 Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True

 Example 2:

 Input: 14
 Returns: False



 */
public class N367_ValidPerfectSquare {
    // binary search, o(logn)
    // 2147483647
    public boolean isPerfectSquare(int num) {
        if(num <=1) return true;
        int left=1, right=num;
        while(left<=right){
            int mid = (right-left)/2 + left;
            long square = (long)mid*mid;   //important, long before the int.
            System.out.println("square="+square);
            if(square < num) left = mid+1;
            else if(square > num) right = mid-1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        N367_ValidPerfectSquare x = new N367_ValidPerfectSquare();
        x.isPerfectSquare(2147483647);

    }

    // math
    // 1= 1
    // 4 = 1+3
    // 9 = 1+3+5
    // 16 = 1+3+5+7
    // ...
    // 1ms
    public boolean isPerfectSquare2(int num) {
        int tmp = 1;
        while(num>0){
            num -= tmp;
            tmp+=2;
        }
        return num == 0;
    }

}
