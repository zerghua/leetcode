package leetcode;
/*
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
	//5 ms
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
}
