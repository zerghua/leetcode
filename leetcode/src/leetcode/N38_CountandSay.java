package leetcode;

/**
 * Created by Hua on 5/22/2016.

 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth sequence.

 1-->1
 2-->11
 3-->21
 4-->1211
 5-->111221
 6-->312211
 7-->13112221


 this one is hard on how to understand the problem and translate it to code.

 */
public class N38_CountandSay {
    // facebook
    // count duplicate chars, and output.
    // 18 / 18 test cases passed. on 8/17/2017
    // 9 ms
    public class Solution {
        public String countAndSay(int n) {
            if(n<1) return null;
            String ret = "1"; //base case when n=1
            int count=1;
            for(int j=1;j<n;j++){
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<ret.length();i++){
                    if(i<ret.length()-1 && ret.charAt(i) == ret.charAt(i+1)){
                        count++;
                    }else{
                        sb.append(count+ ""+ret.charAt(i));
                        count=1;
                    }
                }
                ret = sb.toString();
            }
            return ret;
        }
    }
}
