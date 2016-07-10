package leetcode;

/**
 * Created by Hua on 7/10/2016.
 *
 * Write a function that takes an unsigned integer and
 * returns the number of ¡¯1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ¡¯11' has
 binary representation 00000000000000000000000000001011,
 so the function should return 3.

 Left shift (<<):  -2 << 1 == -4,   10000010 -->  10000100
 right shift (>>): -2 >> 1 == -1    10000010 -->  10000001
 Below only in Java:
 Logical right shift (>>>): -2 >>> 1==2147483647    10000010  -->  01000001 (32bit, 2^31 + 1)

 */
public class N191_Numberof1Bits {
    // 2ms
    public int hammingWeight(int n) {
        int count=0;
        for(int i=0;i<32;i++){
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        N191_Numberof1Bits x = new N191_Numberof1Bits();
        System.out.println(x.hammingWeight(11));

        int a = -2;
        System.out.println(a<<1);  // -4
        System.out.println(a>>1);  // -1
        System.out.println(a>>>1); // 2147483647
    }
}
