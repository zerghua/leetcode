package leetcode;

import java.math.BigInteger;

/**
 * Created by Hua on 4/10/2016.
 */
public class N43_MultiplyStrings {
    //21 ms
    public String multiply(String num1, String num2) {
        BigInteger a= new BigInteger(num1);
        BigInteger b= new BigInteger(num2);
        return a.multiply(b).toString();
    }
}
