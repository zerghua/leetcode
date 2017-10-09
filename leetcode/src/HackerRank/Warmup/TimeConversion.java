package HackerRank.Warmup;

import java.util.*;

/**
 * Created by HuaZ on 10/8/2017.

 Given a time in -hour AM/PM format, convert it to military (-hour) time.

 Note: Midnight is on a -hour clock, and on a -hour clock. Noon is on a -hour clock, and on a -hour clock.

 Input Format

 A single string containing a time in -hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM), where and .

 Output Format

 Convert and print the given time in -hour format, where .

 Sample Input

 07:05:45PM

 Sample Output

 19:05:45

 07:05:45AM  -> 07:05:45    regular AM don't change
 12:00:00AM  -> 00:00:00    12AM to 00

 07:05:45PM  -> 19:05:45    regular PM + 12
 12:00:00PM  -> 12:00:00    12PM won't change

 */
public class TimeConversion {
    static String timeConversion(String s) {
        // Complete this function
        char c = s.charAt(s.length()-2); // A or P
        String mid = s.substring(2,s.length()-2);
        String hh = s.substring(0,2);
        if(c == 'A'){
            if(hh.equals("12")) return "00" + mid;
            return hh + mid;
        }else{  // 'P'
            if(hh.equals("12")) return "12" + mid;
            return (Integer.parseInt(hh) + 12) + mid;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
