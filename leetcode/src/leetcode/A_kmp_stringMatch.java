package leetcode;

/**
 * Created by Hua on 8/26/2016.
 * http://www.cnblogs.com/yjiyjige/p/3263858.html
 */
public class A_kmp_stringMatch {
    // find next array is the most important part in kmp.
    public int[] getNext(String s){
        char[] chars = s.toCharArray();
        int[] next = new int[chars.length];
        int j=0, k=-1;
        next[0] = -1;
        while(j<chars.length -1){
            if(k==-1 || chars[k] == chars[j]) next[++j] = ++k;
            else k = next[k];
        }
        return next;
    }

    public int[] getNext2(String s){
        char[] chars = s.toCharArray();
        int[] next = new int[chars.length];
        int j=0, k=-1;
        next[0] = -1;
        while(j<chars.length -1){
            if(k==-1 || chars[j] == chars[k]) {
                if(chars[++j] == chars[++k]) next[j] = next[k];
                else next[j] = k;
            }
            else k = next[k];
        }
        return next;
    }


    public int kmp(String t, String p){
        char[] tchars = t.toCharArray();
        char[] pchars = p.toCharArray();
        int i=0, j=0;
        //int[] next = getNext(p);
        int[] next = getNext2(p);
        while(i<tchars.length && j<pchars.length){
            if(j== -1 || tchars[i] == pchars[j]){
                i++;j++;
            }else  j = next[j];
        }

        int index = -1;
        if(j == pchars.length) index = i-j;
        System.out.println(index);
        return index;
    }

    public int bruteForceStringMatch(String t, String p){
        char[] tchars = t.toCharArray();
        char[] pchars = p.toCharArray();
        int i=0, j=0;
        while(i<tchars.length && j<pchars.length){
            if(tchars[i] == pchars[j]){
                i++;j++;
            }
            else {
                i = i - j + 1;
                j = 0;
            }
        }

        int index = -1;
        if(j == pchars.length) index = i-j;
        System.out.println(index);
        return index;
    }



    public static void main(String[] args){
        A_kmp_stringMatch x = new A_kmp_stringMatch();
        x.getNext("abcabc");



        x.kmp("aaaaaa", "ab");
        x.kmp("aaaaaa", "aa");
        x.kmp("bbc abcdab abcdabcdabde", "abcdabd");

        x.bruteForceStringMatch("aaaaaa", "ab");
        x.bruteForceStringMatch("aaaaaa", "aa");
        x.bruteForceStringMatch("bbc abcdab abcdabcdabde", "abcdabd");
    }

}
