package leetcode;

/**
 * Created by Hua on 5/25/2016.

 Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.

 case 'I': ret =1;break;
 case 'V': ret =5;break;
 case 'X': ret =10;break;
 case 'L': ret =50;break;
 case 'C': ret =100;break;
 case 'D': ret =500;break;
 case 'M': ret =1000;break;

 */
public class N12_IntegertoRoman {
    // Google, Twitter.
    // 8 ms
    public String intToRoman2(int num) {
        String[] symbol={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[]     value={1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
        StringBuilder sb = new StringBuilder();
        for(int i=0;num!=0; i++){
            while(num >= value[i]){
                num -= value[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }



    //13 ms
    public String constructRomanNumbers(int number, int position){
        String one = "", five= "",ten="";
        switch(position){
            case 1: one = "I"; five = "V"; ten="X"; break;
            case 2: one = "X"; five = "L"; ten="C"; break;
            case 3: one = "C"; five = "D"; ten="M"; break;
            case 4: one = "M";break;
            default: break;
        }

        StringBuilder sb = new StringBuilder();
        if(number <=3){
            for(int i=1;i<=number;i++) sb.append(one);
        }else if(number == 9){
            sb.append(one + ten);
        }else if(number == 4){
            sb.append(one + five);
        }else{ // [5,8]
            sb.append(five);
            for(int i=1;i<=number-5;i++) sb.append(one);
        }
        return sb.toString();
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int pos=1;
        while(num!=0) {
            sb.insert(0, constructRomanNumbers(num%10,pos));
            num /= 10;
            pos++;
        }
        return sb.toString();
    }



}
