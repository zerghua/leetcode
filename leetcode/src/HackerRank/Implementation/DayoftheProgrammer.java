package HackerRank.Implementation;

import java.util.*;

/**
 * Created by HuaZ on 10/11/2017.
 */
public class DayoftheProgrammer {
    // count days in calendar
    // return 256th day in that year
    // return dd.mm.yyyy
    // 1700 <= year <= 2700
    // feb has 28 days, leap year has 29 days
    // [1700,1917] julian calendar, leap years are divisible by 4
    // 1918, transition year, the next day after Jan.31 is Feb.14, means Feb.14 is 32th day of that year
    // [1919,2700] Gregorian calendar, leap year are divisible by 400 or Divisible by 4 and not divisible by 100.
    // leap year is 12.09.yyyy
    // non-leap year is 13.09.yyyy
    // 26.09.1918
    static String solve(int year){
        // Complete this function
        if(year == 1918) return "26.09.1918";
        if(year < 1918) {
            if(year % 4 == 0) return "12.09."+year;
            return "13.09."+year;
        }

        if(year % 400 == 0 || (year %4 ==0 && year%100 !=0)) return "12.09."+year;
        return "13.09."+year;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
