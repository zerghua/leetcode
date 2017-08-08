package leetcode;
/*

Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three",
it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

public int compareVersion(String version1, String version2) {
    String[] arr1 = version1.split("\\.");
    String[] arr2 = version2.split("\\.");
 
    int i=0;
    while(i<arr1.length || i<arr2.length){
        if(i<arr1.length && i<arr2.length){
            if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
                return -1;
            }else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
                return 1;
            }
        } else if(i<arr1.length){
            if(Integer.parseInt(arr1[i]) != 0){
                return 1;
            }
        } else if(i<arr2.length){
           if(Integer.parseInt(arr2[i]) != 0){
                return -1;
            }
        }
 
        i++;
    }
 
    return 0;
}
 */
public class N165_CompareVersionNumbers {
    // Microsoft, Apple
	//5 ms
    // test case:
    // 1.22 >  1.3   (because 22 > 3)
    // 1.22 <  1.101 (because 22 < 101)
    public static int compareVersion(String version1, String version2) {
        String[] v1_array = version1.split("\\.");
        String[] v2_array = version2.split("\\.");
        int min_size = v1_array.length < v2_array.length ? v1_array.length : v2_array.length;
        for(int i=0;i<min_size;i++){
        	int v1 = Integer.parseInt(v1_array[i]);
        	int v2 = Integer.parseInt(v2_array[i]);   
        	if(v1 > v2) return 1;
        	else if(v1 < v2) return -1;
        }
        
        if(v1_array.length > v2_array.length) {
        	for(int i=min_size; i< v1_array.length ; i++)
        		if(Integer.parseInt(v1_array[i]) > 0) return 1;
        }
        else if(v1_array.length < v2_array.length) {
        	for(int i=min_size; i< v2_array.length ; i++)
        		if(Integer.parseInt(v2_array[i]) > 0) return -1;
        }
    	return 0;
    }
    
    public static void main(String[] args) {	
    	int ret =compareVersion("0", "1");
    	System.out.println(ret);
    }

    // potential issue when num1 or num2 > Integer.Max_Value
    // 1 ms 71 / 71 test cases passed.
    public class Solution {
        public int compareVersion(String version1, String version2) {
            int i=0,j=0;
            char[] c1 = version1.toCharArray(), c2 = version2.toCharArray();
            while(i<c1.length || j<c2.length){
                int num1=0, num2=0;
                while(i<c1.length && c1[i] != '.') num1 = num1*10 + c1[i++] -'0';
                while(j<c2.length && c2[j] != '.') num2 = num2*10 + c2[j++] -'0';
                if(num1 > num2) return 1;
                if(num1 < num2) return -1;
                i++;j++;
            }
            return 0;
        }
    }
}
