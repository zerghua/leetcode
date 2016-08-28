package leetcode;

/**
 * Created by Hua on 8/20/16.

 Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.

 For example,

 123 -> "One Hundred Twenty Three"
 12345 -> "Twelve Thousand Three Hundred Forty Five"
 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

 Hint:

 1. Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 2. Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000
 and convert just that chunk to words.
 3. There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010?
 (middle chunk is zero and should not be printed out)


 test cases:
 0
 123
 123000
 1000010  (only one missed)

 */
public class N273_IntegertoEnglishWords {
    // 5ms
    // many corner cases
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder ret = new StringBuilder();
        int level=0;
        while(num != 0){
            if(num%1000 !=0) ret.insert(0, convertThreeDigits(num%1000, level) + " ");
            num /= 1000;
            level++;
        }
        return ret.toString().trim();
    }

    public String convertThreeDigits(int num, int level){
        if(num == 0) return "";
        String ret = "";
        if(num < 100) ret += convertTwoDigits(num);
        else ret += convertSingleDigits(num/100)+ " Hundred " + convertTwoDigits(num%100);

        ret = ret.trim();
        if(level == 1) ret += " Thousand";
        else if(level == 2) ret += " Million";
        else if(level == 3) ret += " Billion";

        return ret.trim();
    }

    public String convertTwoDigits(int num){
        String ret ="";
        if(num< 10) ret = convertSingleDigits(num);
        else if(num < 20){  // in [10,19]
            switch(num){
                case 10: ret = "Ten";break;
                case 11: ret = "Eleven";break;
                case 12: ret = "Twelve";break;
                case 13: ret = "Thirteen";break;
                case 14: ret = "Fourteen";break;
                case 15: ret = "Fifteen";break;
                case 16: ret = "Sixteen";break;
                case 17: ret = "Seventeen";break;
                case 18: ret = "Eighteen";break;
                case 19: ret = "Nineteen";break;
                default: ret = "";
            }
        }
        else{ // in [20,99]
            switch (num/10){
                case 2: ret = "Twenty";break;
                case 3: ret = "Thirty";break;
                case 4: ret = "Forty";break;
                case 5: ret = "Fifty";break;
                case 6: ret = "Sixty";break;
                case 7: ret = "Seventy";break;
                case 8: ret = "Eighty";break;
                case 9: ret = "Ninety";break;
            }
            ret += " " + convertSingleDigits(num%10);
        }
        return ret.trim();
    }

    public String convertSingleDigits(int num){
        String ret;
        switch(num){
            case 1: ret = "One";break;
            case 2: ret = "Two";break;
            case 3: ret = "Three";break;
            case 4: ret = "Four";break;
            case 5: ret = "Five";break;
            case 6: ret = "Six";break;
            case 7: ret = "Seven";break;
            case 8: ret = "Eight";break;
            case 9: ret = "Nine";break;
            default: ret = "";
        }
        return ret.trim();
    }
}
