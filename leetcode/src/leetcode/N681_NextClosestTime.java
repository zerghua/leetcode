package leetcode;

import java.util.HashSet;

/**
 * Created by Hua on 9/26/2017.

 Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 here is no limit on how many times a digit can be reused.

 You may assume the given input string is always valid.
 For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

 Example 1:

 Input: "19:34"
 Output: "19:39"
 Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
 It is not 19:33, because this occurs 23 hours and 59 minutes later.

 Example 2:

 Input: "23:59"
 Output: "22:22"
 Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.


 */
public class N681_NextClosestTime {
    // adapted from others solution
    // basically increase min one by one
    // 62 / 62 test cases passed.
    // 75 ms
    class Solution {
        public String nextClosestTime(String time) {
            String ret;
            int a = Integer.parseInt(time.substring(0,2));
            int b = Integer.parseInt(time.substring(3,5));

            boolean[] v = new boolean[128];
            for(char c : time.toCharArray()) v[c] = true;

            while(true) {
                b++;
                if(b == 60){
                    b = 0;
                    a++;
                    if(a == 24) a = 0;
                }
                ret = String.format("%02d:%02d", a,b);  // pad 0 in front of number with length 2
                boolean isFound = true;
                for(char c : ret.toCharArray()) if(v[c] == false) isFound = false;  // check if all digit in set
                if(isFound) break;
            }
            return ret;
        }
    }

    // my verbose solution
    // 62 / 62 test cases passed.
    // 8 ms
    class Solution2 {
        public String nextClosestTime(String time) {
            String[] str = time.split(":");
            String hour = str[0];  //  should less than 24
            String min = str[1];    //  should less than 60
            HashSet<Integer> set = new HashSet();
            int small = 9;
            for(int i=0; i<=4; i++){
                if(i == 2) continue;
                int num = time.charAt(i) - '0';
                small = Math.min(small, num);
                set.add(num);
            }

            for(int i=4; i>=0; i--){
                if(i == 2) continue;
                if(i>2){ // mins, a bug fix last digit as well
                    for(int num : set){
                        if(num > time.charAt(i) - '0'){
                            StringBuilder tmp = new StringBuilder(min);
                            tmp.setCharAt(i-3, (char)(num + '0'));
                            if(Integer.parseInt(tmp.toString()) < 60) {
                                if(i == 4) return hour +":" + tmp.toString();
                                return hour +":" + (char)(num + '0') + "" + small;
                            }
                        }
                    }
                }else{  // hours, a bug fix min as well
                    for(int num : set){
                        if(num > time.charAt(i) - '0'){
                            StringBuilder tmp = new StringBuilder(hour);
                            tmp.setCharAt(i, (char)(num + '0'));
                            if(Integer.parseInt(tmp.toString()) < 24) return tmp.toString() +":" + small + "" + small;
                        }
                    }
                }
            }

            return small + "" + small + ":" + small + "" + small;
        }
    }
}
