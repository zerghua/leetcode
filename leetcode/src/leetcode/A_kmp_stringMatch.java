package leetcode;

/**
 * Created by Hua on 8/26/2016.
 * http://www.cnblogs.com/yjiyjige/p/3263858.html

 abcabcdh
 01234567
 j=0 k=-1
 next[1]=0 k=0

 j=1 k=0
 now k=-1

 j=1 k=-1
 next[2]=0 k=0

 j=2 k=0
 now k=-1

 j=2 k=-1
 next[3]=0 k=0

 j=3 k=0
 next[4]=1 k=1

 j=4 k=1
 next[5]=2 k=2

 j=5 k=2
 next[6]=3 k=3

 j=6 k=3
 now k=0

 j=6 k=0
 now k=-1

 j=6 k=-1
 next[7]=0 k=0


 ababc

 j=0 k=-1
 next[1]=0 k=0

 j=1 k=0
 now k=-1

 j=1 k=-1
 next[2]=0 k=0

 j=2 k=0
 next[3]=1 k=1

 j=3 k=1
 next[4]=2 k=2


 aaabc (limitation of KMP)
 01234

 j=0 k=-1
 next[1]=0 k=0

 j=1 k=0
 next[2]=1 k=1

 j=2 k=1
 next[3]=2 k=2

 j=3 k=2
 now k=1

 j=3 k=1
 now k=0

 j=3 k=0
 now k=-1

 j=3 k=-1
 next[4]=0 k=0


 abcde
 01234
 j=0 k=-1
 next[1]=0 k=0

 j=1 k=0
 now k=-1

 j=1 k=-1
 next[2]=0 k=0

 j=2 k=0
 now k=-1

 j=2 k=-1
 next[3]=0 k=0

 j=3 k=0
 now k=-1

 j=3 k=-1
 next[4]=0 k=0


 abababc
 0123456

 j=0 k=-1
 next[1]=0 k=0

 j=1 k=0
 now k=-1

 j=1 k=-1
 next[2]=0 k=0

 j=2 k=0
 next[3]=1 k=1

 j=3 k=1
 next[4]=2 k=2

 j=4 k=2
 next[5]=3 k=3

 j=5 k=3
 next[6]=4 k=4

 so it seems like k is the prefix, and j is the suffix.


 */
public class A_kmp_stringMatch {
    // find next array is the most important part in kmp.
    // This is actually DP
    // if p[k] == p[j], then  next[j+1] = next[j] + 1  and next[j] == k   --->  next[++j] = ++k
    // if p[k] != p[j], then fall back to its prefix, k = next[k]
    public int[] getNext(String s){
        char[] chars = s.toCharArray();
        int[] next = new int[chars.length];
        int j=0, k=-1;
        next[0] = -1;
        System.out.println(s);
        while(j<chars.length -1){
            System.out.printf("\nj=%d k=%d \n",j,k);
            if(k==-1 || chars[k] == chars[j]) {
                next[++j] = ++k;
                System.out.printf("next[%d]=%d k=%d \n",j,next[j],k);
            }
            else {
                k = next[k];    // kind of recursive
                System.out.printf("now k=%d \n",k);
            }
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
        //x.getNext("abcabcdh");
        //x.getNext("ababc");
        //x.getNext("aaabc");
        //x.getNext("abcde");
        x.getNext("abababc");


        /*
        x.kmp("aaaaaa", "ab");
        x.kmp("aaaaaa", "aa");
        x.kmp("bbc abcdab abcdabcdabde", "abcdabd");

        x.bruteForceStringMatch("aaaaaa", "ab");
        x.bruteForceStringMatch("aaaaaa", "aa");
        x.bruteForceStringMatch("bbc abcdab abcdabcdabde", "abcdabd");
        */
    }

}
