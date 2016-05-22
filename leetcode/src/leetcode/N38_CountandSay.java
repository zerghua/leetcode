package leetcode;

/**
 * Created by Hua on 5/22/2016.

 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth sequence.

 1£º1
 2£º11
 3£º21
 4£º1211
 5£º111221
 6£º312211
 7£º13112221


 */
public class N38_CountandSay {
    //8 ms
    //count duplicate chars, and output.
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
