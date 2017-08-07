package leetcode;

/**
 * Created by Hua on 5/14/2016.
 *
 * '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 Some examples:
 isMatch("aa","a") ? false
 isMatch("aa","aa") ? true
 isMatch("aaa","aa") ? false
 isMatch("aa", "*") ? true
 isMatch("aa", "a*") ? true
 isMatch("ab", "?*") ? true
 isMatch("aab", "c*a*b") ? false
 */
public class N44_WildcardMatching {
    // Google, Facebook
    // greedy
    // let the previous star match as less as possible, and delegate it to following star
    // so previous star don't need to redo the following star's job.
    // need to think through how multiple stars co-work
    // 6 ms
    public boolean isMatch2(String s, String p) {
        int i=0, j=0, star_index=-1, i_index=-1;
        while(i<s.length()){
            if(j<p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j)=='?')){
                i++;j++;
            }
            else if(j<p.length() && p.charAt(j)=='*'){
                star_index = j;
                i_index = i;
                j++;
            }
            else if(star_index != -1){
                j = star_index+1;
                i = ++i_index;
            }else return false;
        }
        while(j<p.length() && p.charAt(j) == '*') j++;
        return j == p.length();
    }


    // first TLE
    // "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"
    // "a*******b"

    // second TLE
    //"abbbaaaaaaaabbbabaaabbabbbaabaabbbbaabaabbabaabbabbaabbbaabaabbabaabaabbbbaabbbaabaaababbbbabaaababbaaa"
    //"ab**b*bb*ab**ab***b*abaa**b*a*aaa**bba*aa*a*abb*a*a"
    public boolean isMatch(String s, String p) {
        System.out.println(s+ "] [" +p);

        if(p.length() == 0) return s.length() == 0;

        //to solve the first TLE
        if(p.length()>1 && p.charAt(0)=='*' && p.charAt(1)=='*')
            return isMatch(s,p.substring(1));

        if(s.length() == 0) {
            if(p.charAt(0) == '*') return isMatch(s, p.substring(1));
            else return false;
        }

        //both s and p has length >=1
        if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'){
            return isMatch(s.substring(1), p.substring(1));
        }else if(p.charAt(0) == '*'){
            for(int i=1;i<=s.length();i++){
                if(isMatch(s.substring(i), p.substring(1))) return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
        N44_WildcardMatching x= new N44_WildcardMatching();
        x.isMatch2("ababababab", "a*b*b");

    }
}
