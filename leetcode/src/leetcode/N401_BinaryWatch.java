package leetcode;

import javafx.beans.binding.IntegerBinding;

import java.util.*;

/**
 * Created by HuaZ on 10/16/2016.

 A binary watch has 4 LEDs on the top which represent the hours (0-11),
 and the 6 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.

 For example, the above binary watch reads "3:25".

 Given a non-negative integer n which represents the number of LEDs that are currently on,
 return all possible times the watch could represent.

 Example:

 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

 Note:

 The order of output does not matter.
 The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 The minute must be consist of two digits and may contain a leading zero,
 for example "10:2" is not valid, it should be "10:02".


 */
public class N401_BinaryWatch {
    // Google
    // Integer.bitCount(i) + Integer.bitCount(j) == num
    // 10 / 10 test cases passed.  on 8/26/2017
    // 31 ms
    public class Solution {
        public List<String> readBinaryWatch(int num) {
            List<String> ret = new LinkedList();
            for(int i=0; i<= 11; i++){
                for(int j=0; j<= 59;j++){
                    if(Integer.bitCount(i) + Integer.bitCount(j) == num){
                        ret.add(String.format("%d:%02d",i,j));
                    }
                }
            }
            return ret;
        }
    }


    // 3 ms  10 / 10 test cases passed.
    // hour[0-11]: 1,2,4,8,  can't have leading zeros
    // minutes[0-59]: 1,2,4,8,16,32,  should have leading zeros if less than 10
    // Key part is to combine hour and min to an array and go through them for DFS.
    // has to have a count
    public class Solution2 {
        public List<String> readBinaryWatch(int num) {
            List<String> ret = new ArrayList();
            int[] time =  new int[]{1,2,4,8,1,2,4,8,16,32};
            dfs(ret, 0, 0, 0, num, 0, time);
            return ret;
        }

        public void dfs(List<String> ret, int hour, int min, int start, int num, int count, int[] time){
            if(hour > 11 || min > 59) return;

            if(count == num){
                String mm = (min<10)? "0"+min : ""+min; //leading zeros for minutes
                ret.add(""+ hour + ":" + mm);
                return;
            }

            for(int i=start;i<time.length;i++){
                int newHH = (i<4)? hour + time[i] : hour;
                int newMM = (i<4)? min : min + time[i];
                dfs(ret, newHH, newMM, i+1, num, count+1, time);
            }
        }
    }

    // interesting
    // 2 ms 10 / 10 test cases passed.
    // https://discuss.leetcode.com/topic/59761/just-for-fun-java-1ms-beats-100
    public class Solution3 {
        String[][] hour = {{"0"},
                {"1", "2", "4", "8"},
                {"3", "5", "6", "9", "10"},
                {"7", "11"}};
        String[][] minute = {{"00"}, //1
                {"01", "02", "04", "08", "16", "32"}, //6
                {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"}, //15
                {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"}, //20
                {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"}, //14
                {"31", "47", "55", "59"}}; //4

        public List<String> readBinaryWatch(int num) {
            List<String> ret = new ArrayList();
            for (int i = 0; i <= 3 && i <= num; i++) {
                if (num - i <= 5) {
                    for (String str1 : hour[i]) {
                        for (String str2 : minute[num - i]) {
                            ret.add(str1 + ":" + str2);
                        }
                    }
                }
            }
            return ret;
        }
    }
}
