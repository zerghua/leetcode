package leetcode;

import java.util.HashMap;

/**
 * Created by Hua on 5/22/2016.

 You are playing the following Bulls and Cows game with your friend:
 You write down a number and ask your friend to guess what the number is.
 Each time your friend makes a guess, you provide a hint that indicates
 how many digits in said guess match your secret number exactly in both
 digit and position (called "bulls") and how many digits match the secret
 number but locate in the wrong position (called "cows"). Your friend will
 use successive guesses and hints to eventually derive the secret number.

 For example:

 Secret number:  "1807"
 Friend's guess: "7810"

 Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)

 Write a function to return a hint according to the secret number and
 friend's guess, use A to indicate the bulls and B to indicate the cows.
 In the above example, your function should return "1A3B".

 Please note that both secret number and friend's guess may contain
 duplicate digits, for example:

 Secret number:  "1123"
 Friend's guess: "0111"

 In this case, the 1st 1 in friend's guess is a bull, the 2nd or
 3rd 1 is a cow, and your function should return "1A1B".

 You may assume that the secret number and your friend's guess only
 contain digits, and their lengths are always equal.

 */
public class N299_BullsandCows {
    //14 ms
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> hm = new HashMap<>();
        boolean[] isBull = new boolean[secret.length()];
        int num_bull=0;
        for(int i=0;i<secret.length();i++){
            char secret_char = secret.charAt(i);
            if(secret_char == guess.charAt(i)){
                isBull[i] = true;
                num_bull++;
            }else{
                if(hm.containsKey(secret_char)) hm.put(secret_char, hm.get(secret_char)+1);
                else hm.put(secret_char,1);
            }
        }

        int num_cow = 0;
        for(int i=0;i<secret.length();i++){
            char guess_char = guess.charAt(i);
            if(!isBull[i] && hm.containsKey(guess_char)){
                num_cow++;
                if(hm.get(guess_char) == 1){hm.remove(guess_char);}
                else hm.put(guess_char,hm.get(guess_char)-1);
            }
        }
        return num_bull+"A"+num_cow+"B";
    }

    //6 ms
    public String getHint2(String secret, String guess) {
        int num_bull=0, num_cow=0;
        int[] nums = new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)) num_bull++;
            else{
                if(nums[secret.charAt(i)-'0']++ < 0) num_cow++;
                if(nums[guess.charAt(i)-'0']--  > 0) num_cow++;
            }
        }
        return num_bull+"A"+num_cow+"B";
    }

}
