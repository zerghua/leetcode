package leetcode;

/**
 * Created by Hua on 8/28/16.
 */
public class A_calculateExponentiation {

    // return k^1 + k^2 + ... k^n
    public double getExponentiation(double k, int n){
        double ret=0;
        for(int i=0;i<n;i++){
            ret+= Math.pow(k,i);
        }
        return ret;
    }

    public static void main(String[] args){
        A_calculateExponentiation x = new A_calculateExponentiation();
        double house_price_increase_rate=1.05;
        int year = 10;
        double ret = x.getExponentiation(house_price_increase_rate, year);

        double tax_rate = 0.0125;
        System.out.println(ret);
        System.out.println((ret-year)*tax_rate);

        double housePrice = 800;
        System.out.println((ret-year)*tax_rate*housePrice);

        housePrice = 700;
        System.out.println((ret-year)*tax_rate*housePrice);

        String a = "1";
        String b= "中";
        x.testUnicode(a);
        x.testUnicode(b);
    }


    public void testUnicode(String a){
        System.out.println("a="+a+ " num="+(int)a.charAt(0));
    }

}
