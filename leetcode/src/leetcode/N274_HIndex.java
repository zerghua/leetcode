package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Hua on 5/29/2016.

 Given an array of citations (each citation is a non-negative integer) of a researcher,
 write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h
 if h of his/her N papers have at least h citations each, and the other N ? h papers
 have no more than h citations each."

 For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining two
 with no more than 3 citations each, his h-index is 3.

 Note: If there are several possible values for h, the maximum one is taken as the h-index.

 Hint:

 An easy approach is to sort the array first.
 What are the possible values of h-index?
 A faster approach is to use extra space.


 */
public class N274_HIndex {
    // Google, Facebook
    // 11 ms
    // sort, space o(1), time o(nlogn)
    // https://en.wikipedia.org/wiki/H-index
    public int hIndex(int[] citations) {
        if(citations ==null || citations.length ==0) return 0;
        Integer[] citations_list = new Integer[citations.length];
        for(int i=0;i<citations.length;i++) citations_list[i]=citations[i];
        Arrays.sort(citations_list, Collections.reverseOrder());

        for(int i=0; i<citations_list.length;i++){
            if(citations_list[i] <= i ) return i;
        }
        return citations_list.length;
    }

    // counting sort
    // space o(n), time o(n)
    // stat stores how many citations at i
    // need to find the max of citations >= i
    // 1 ms
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] stat = new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>= n) stat[n] += 1;
            else stat[citations[i]] +=1;
        }

        int sum=0;
        for(int i=n;i>0;i--){
            sum+= stat[i];
            if(sum>= i) return i;
        }
        return 0;
    }

}
