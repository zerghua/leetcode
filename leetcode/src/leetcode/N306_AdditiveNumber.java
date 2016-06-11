package leetcode;
import java.math.BigInteger;

/**
 * Created by Hua on 6/10/2016.

 Additive number is a string whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers.
 Except for the first two numbers, each subsequent number in the sequence
 must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form
 an additive sequence: 1, 1, 2, 3, 5, 8.

 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.

 1 + 99 = 100, 99 + 100 = 199

 Note: Numbers in the additive sequence cannot have leading zeros,
 so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 Given a string containing only digits '0'-'9', write a function to determine
 if it's an additive number.

 Follow up:
 How would you handle overflow for very large input integers?

 111            false
 112358         true
 198019823962   true


 */
public class N306_AdditiveNumber {
    // backtracking
    // 12 ms
    public boolean isAdditiveNumber(String num) {
        if(num.length() <3) return false;
        for(int i=0; i<num.length()/3;i++){
            String first_num = num.substring(0,i+1);
            if(first_num.length()>1 && first_num.charAt(0)=='0') break;
            if(isAdditiveNumber(num,i+1,i+1,first_num)) return true;
        }
        return false;
    }


    public boolean isAdditiveNumber(String num, int left, int right, String preSum) {
        for(int i = right;i<num.length();i++){
            String curNum = num.substring(left, i + 1);
            if(curNum.length()>1 && curNum.charAt(0)=='0') break;
            for(int j=i+1;j<num.length();j++){
                String nextNum = num.substring(i+1, j+1);
                if(nextNum.length()>1 && nextNum.charAt(0)=='0') break;
                BigInteger a = new BigInteger(preSum);
                if(a.add(new BigInteger(curNum)).equals(new BigInteger(nextNum))){
                    if(j+1 >=num.length() || isAdditiveNumber(num, i+1,i+1,curNum)) return true;

                }else if(a.add(new BigInteger(curNum)).compareTo(new BigInteger(nextNum)) < 0) break;
            }
        }
        return false;
    }

    //iterative
    // 4 ms
    public boolean isAdditiveNumber2(String num) {
        if(num == null || num.length()<3) return false;
        int n=num.length();
        for(int i=1;i<n;i++){
            if(i>1 && num.charAt(0) == '0') break; //pruning 0112
            for(int j=i+1;j<n;j++){
                int first = 0, second = i, third = j;
                if(num.charAt(i) == '0' && third >second+1) break; // pruning
                while(third<n){
                    Long sum = Long.valueOf(num.substring(first,second)) +
                                  Long.valueOf(num.substring(second,third));
                    if(num.substring(third).startsWith(sum.toString())){
                        first=second;
                        second = third;
                        third += sum.toString().length();
                    }else break;
                }
                if(third == n) return true;
            }
        }
        return false;
    }
}
