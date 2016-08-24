package leetcode;
import java.util.*;

/**
 * Created by Hua on 8/24/2016.
 *
 *
 * counting sort:  can be stable sort(loops from right), o(n+k) time, o(n+k) space, k is the largest number in array.
 * limitation, if k is large, will require a lot of spaces.
 * https://en.wikipedia.org/wiki/Counting_sort
 * https://zh.wikipedia.org/wiki/%E8%AE%A1%E6%95%B0%E6%8E%92%E5%BA%8F
 * https://www.cs.usfca.edu/~galles/visualization/CountingSort.html
 *
 * difference between  Arrays.copyOf and System.arraycopy: http://www.programcreek.com/2015/03/system-arraycopy-vs-arrays-copyof-in-java/
 * Arrays.copyOf will create a new array,  instead System.arraycopy will copy to existing array.
 *
 */



public class A_countingSort {
    // stable sort
    public void countingSort(int[] a, int k ){
        int[] count = new int[k];
        int[] tmp =  new int[a.length];
        for(int i=0;i<a.length;i++) {
            count[a[i]]++;
        }

        // to record position of each item, important i<k, for stable sort
        for(int i=1;i<k;i++) {
            count[i] += count[i-1];
        }

        for(int i=a.length-1; i>=0;i--){
            tmp[count[a[i]]-1] = a[i];
            count[a[i]]--;
        }

        //a = Arrays.copyOf(tmp, tmp.length);  // this will cause a not be changed in called function.
        System.arraycopy(tmp,0,a,0,a.length);  // equals for(int i=0;i<a.length;i++) a[i] = tmp[i];
    }


    //unstable sort
    public void countingSort2(int[] a, int k ) {
        int[] count = new int[k];
        for(int i=0;i<a.length;i++) {
            count[a[i]]++;
        }

        int index=0;
        for(int i=0;i<k;i++){
            while(count[i]-- > 0){
                a[index++] = i;
            }
        }

    }


    public static void main(String[] args){
        System.out.println("helleo woord");

        int[] a = new int[]{6,5,3,3,3,2,1};
        System.out.println(Arrays.toString(a));

        A_countingSort x = new A_countingSort();
        x.countingSort(a,7);

        System.out.println("after sort:");
        System.out.println(Arrays.toString(a));


        x.countingSort2(a,7);
        System.out.println("after sort:");
        System.out.println(Arrays.toString(a)); //
    }
}
