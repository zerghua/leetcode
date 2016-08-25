package leetcode;

import java.util.Arrays;

/**
 * Created by Hua on 8/25/2016.
 */
public class A_radixSort {
    // current implementation only works for non-negative numbers.
    // for negative number might sort by byte instead of digit, but also to tricky.
    public void radixSort(int[] a){
        int maxNumber=Integer.MIN_VALUE;
        for(int i: a) maxNumber = Math.max(maxNumber, i);

        for(int digit=1; maxNumber/digit > 0; digit *=10){
            countingSort(a, digit);
        }
    }

    public void countingSort(int[] a, int digit){
        int n = a.length;
        int[] sorted = new int[n];
        int[] count = new int[10];  // digit from 0-9

        for(int i=0;i<n;i++){
            count[(a[i]/digit)%10]++;
        }

        for(int i=1;i<10;i++){
            count[i] += count[i-1];
        }

        for(int i=n-1;i>=0;i--){
            sorted[count[(a[i]/digit)%10] - 1] = a[i];
            count[(a[i]/digit)%10]--;
        }
        System.arraycopy(sorted,0,a,0,n);
    }

    public static void main(String[] args){
        System.out.println("helleo woord");

        int[] a = new int[]{666,37,2,3,1234,0,1};  //-333
        System.out.println(Arrays.toString(a));

        A_radixSort x = new A_radixSort();
        x.radixSort(a);

        System.out.println("after sort:");
        System.out.println(Arrays.toString(a));

    }

}
