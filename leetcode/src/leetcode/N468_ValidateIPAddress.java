package leetcode;

/**
 * Created by HuaZ on 12/17/2016.

 In this problem, your job to write a function to check whether a input string is a valid IPv4 address
 or IPv6 address or neither.

 IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
 each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

 Besides, you need to keep in mind that leading zeros in the IPv4 is illegal.
 For example, the address 172.16.254.01 is illegal.

 IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
 The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334
 is a legal one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case
 characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6
 address(Omit leading zeros and using upper cases).

 However, we don't replace a consecutive group of zero value with a single empty group using two consecutive
 colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

 Besides, you need to keep in mind that extra leading zeros in the IPv6 is also illegal. For example,
 the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is also illegal.

 Note: You could assume there is no extra space in the test cases and there may some special characters
 in the input string.

 Example 1:

 Input: "172.16.254.1"

 Output: "IPv4"

 Explanation: This is a valid IPv4 address, return "IPv4".

 Example 2:

 Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

 Output: "IPv6"

 Explanation: This is a valid IPv6 address, return "IPv6".

 Example 3:

 Input: "256.256.256.256"

 Output: "Neither"

 Explanation: This is neither a IPv4 address nor a IPv6 address.


 */
public class N468_ValidateIPAddress {
    // Twitter
    // 8 ms 95 / 95 test cases passed.
    // String
    // tricky to make the code clean.
    public class Solution {
        public String validIPAddress(String IP) {
            boolean is4 = IP.indexOf('.') > -1;
            char delimiter = is4? '.' : ':';
            int maxToken = is4 ? 4 : 8;
            int maxDigit = is4 ? 3 : 4;
            if(IP.length() > maxToken * maxDigit + maxToken - 1) return "Neither";

            char[] ip = IP.toCharArray();
            int digit =0, token=1, val=0;
            for(int i=0;i<ip.length;i++){
                if(ip[i] == delimiter){
                    token++;
                    if(digit == 0 || token > maxToken) return "Neither";
                    digit = val = 0;
                }else if((ip[i] >= 'a' && ip[i] <= 'f') || (ip[i] >= 'A' && ip[i] <= 'F') ||
                         (ip[i] >= '0' && ip[i] <= '9')){
                    digit++;
                    val = val * 10 + ip[i] - '0'; // get IP4 value, IP6 are not checked.
                    if(digit > maxDigit || is4 && (ip[i] > '9' || val > 255 || digit==2 && ip[i-1] =='0'))//key!
                        return "Neither";
                }else return "Neither";
            }
            return token == maxToken && digit > 0 ? is4? "IPv4" : "IPv6" : "Neither";
        }
    }
}
