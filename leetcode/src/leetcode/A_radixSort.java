package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

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
            int val = (a[i]/digit)%10;
            count[val]++;
        }

        for(int i=1;i<10;i++){
            count[i] += count[i-1];
        }

        for(int i=n-1;i>=0;i--){
            int val = (a[i]/digit)%10;
            sorted[count[val] - 1] = a[i];
            count[val]--;
        }
        System.arraycopy(sorted,0,a,0,n);
    }

    // use bit instead of digit, assume 32-bit integer
    // not can handle negative numbers
    public void radixSort2(int[] a){
        for(int bit=0; bit<32; bit++){
            countingSortBit(a, bit);
        }
        rotateArray(a); // rotate array, see N189_Rotate_Array
    }

    public void countingSortBit(int[] a, int bit){
        int n = a.length;
        int[] sorted = new int[n];
        int[] count = new int[2];

        for(int i=0;i<n;i++){
            int val = (a[i]>> bit) & 1;
            count[val]++;
        }

        for(int i=1;i<2;i++){
            count[i] += count[i-1];
        }

        for(int i=n-1;i>=0;i--){
            int val = (a[i]>> bit) & 1;
            sorted[count[val] - 1] = a[i];
            count[val]--;
        }
        System.arraycopy(sorted,0,a,0,n);
    }

    public void rotateArray(int [] a ){
        int k=-1;
        for(int i=0; i<a.length;i++){
            if(a[i] <0) {
                k=i;
                break;
            }
        }
        if(k == -1) return;
        reverseArray(a, 0, k-1);
        reverseArray(a, k, a.length-1);
        reverseArray(a, 0, a.length-1);
    }

    public void reverseArray(int[] a, int start, int end){
        while(start < end){
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;end--;
        }
    }


    public static void main(String[] args){
        System.out.println("helleo woord");
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{666,37,2,3,1234,0,1,-1,-2,-33});
        list.add(new int[]{666,37,2,3,1234,0,1,-1});
        list.add(new int[]{666,37,2,3,1234,0,1});

        for(int[] a: list) {
            System.out.println(Arrays.toString(a));
            A_radixSort x = new A_radixSort();
            //x.radixSort(a);
            x.radixSort2(a);

            System.out.println("after sort:");
            System.out.println(Arrays.toString(a));
            System.out.println();
        }
    }

}
