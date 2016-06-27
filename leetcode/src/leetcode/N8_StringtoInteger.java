package leetcode;

/**
 * Created by Hua on 5/23/2016.

 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases.
 If you want a challenge, please do not see below and ask yourself what
 are the possible input cases.

 Notes: It is intended for this problem to be specified
 vaguely (ie, no given input specs). You are responsible to
 gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated.
 If you still see your function signature accepts a const char * argument,
 please click the reload button to reset your code definition.

 spoilers alert... click to show requirements for atoi.
 Requirements for atoi:

 The function first discards as many whitespace characters as necessary
 until the first non-whitespace character is found. Then, starting from
 this character, takes an optional initial plus or minus sign followed
 by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the
 integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral
 number, or if no such sequence exists because either str is empty or it contains
 only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.
 If the correct value is out of the range of representable values,
 INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.


 */
public class N8_StringtoInteger {
    //4 ms
    public int myAtoi(String str) {
        if(str == null || str.length()==0) return 0;
        // parse input, find start index and sign
        int start_index=0;
        boolean is_negative=false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' ' || str.charAt(i)=='0') continue; // discard leading space
            if(isNumber(str.charAt(i))){
                start_index = i;
                break;
            }
            else if(str.charAt(i) == '+' && i+1<str.length() && isNumber(str.charAt(i+1))){
                start_index = i+1;
                break;
            }
            else if(str.charAt(i) == '-' && i+1<str.length() && isNumber(str.charAt(i+1))){
                start_index = i+1;
                is_negative=true;
                break;
            }
            else return 0;
        }

        // get numeric part from start index
        // ignore trailing non-number chars
        int end_index=start_index;
        for(int i=start_index;i<str.length()-1;i++){
            if(isNumber(str.charAt(i+1))) end_index = i+1;
            else break;
        }

        // parse to int, be aware of overflow
        long ret=0;
        for(int i=start_index;i<=end_index;i++){
            ret = (long)ret*10 + (str.charAt(i)-'0');
            if(ret > Integer.MAX_VALUE) {
                if(is_negative) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
        }
        if(is_negative) ret*=-1;
        return (int)ret;
    }

    private boolean isNumber(char c){
        return c>= '0' && c<= '9';
    }


    // cleaner code
    // 4ms
    public int myAtoi2(String str) {
        if(str == null || str.length()==0) return 0;
        str = str.trim(); // discard leading space

        int index=0;
        int sign= 1;
        if(str.charAt(0) == '+') index++;
        else if(str.charAt(0) == '-') {
            index++;
            sign = -1;
        }

        long ret = 0;
        while(index<str.length()){
            if(str.charAt(index) <'0' || str.charAt(index) > '9') break;
            ret = (long)ret*10 + (str.charAt(index)-'0');
            if(ret > Integer.MAX_VALUE) {
                return sign>0? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }
        return (int) ret*sign;
    }


    public static void main(String[] args) {
        N8_StringtoInteger x= new N8_StringtoInteger();
        System.out.println(x.myAtoi("123"));
        System.out.println(x.myAtoi("abc123"));
        System.out.println(x.myAtoi("123abc"));
        System.out.println(x.myAtoi("  0123dsd  "));
        System.out.println(x.myAtoi(String.valueOf(Integer.MIN_VALUE)));
        System.out.println(x.myAtoi(String.valueOf(Integer.MAX_VALUE)));


        System.out.println(Math.floor(Math.sqrt(12)));

        //System.out.println(Integer.MIN_VALUE);
    }

}
