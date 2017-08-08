package leetcode;

/**
 * Created by Hua on 7/21/2017.


 Given two strings S and T, determine if they are both one edit distance apart.

 */
public class N161_OneEditDistance {
    // facebook, snapchat, uber, twitter
    // a few conditions.
    // 131 / 131 test cases passed.
    // 4 ms
    public class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if(s.length() < t.length()) return isOneEditDistance(t, s);  // make sure s is longer than t
            if(s.length() - t.length() > 1) return false;
            if(s.length() == t.length()) return isModify(s, t);
            return isOneMore(s, t);
        }

        public boolean isModify(String s, String t){
            int diff = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) != t.charAt(i)) diff++;
            }
            return diff == 1;
        }

        public boolean isOneMore(String s, String t){
            for(int i=0; i<t.length();i++){
                if(s.charAt(i) != t.charAt(i)) return s.substring(i+1).equals(t.substring(i));
            }
            return true; // s has one extra char at the end
        }
    }


    // another solution
    // 131 / 131 test cases passed.
    // 2 ms
    public class Solution2 {
        public boolean isOneEditDistance(String s, String t) {
            int m = s.length(), n = t.length();
            if (m > n) return isOneEditDistance(t, s); //make sure s is shorted than t

            int i = 0, diff = n - m;
            if (diff > 1) return false;

            while (i < m && s.charAt(i) == t.charAt(i)) i++;
            if (i == m) return diff == 1; //append case, return false if s==t
            if (diff == 0) i++; // for modify case

            while (i < m && s.charAt(i) == t.charAt(i + diff)) i++; //insert and modify case.
            return i == m;
        }
    }
}
