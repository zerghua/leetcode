package leetcode;
/*
 * https://en.wikipedia.org/wiki/Catalan_number
 ����f(n)Ϊunique BST����������n = 3Ϊ����

�����BST�ĸ��ڵ����ȡ{1, 2, 3}�е���һ���֡�

����1Ϊ�ڵ㣬��left subtreeֻ����0���ڵ㣬��right subtree��2, 3�����ڵ㡣
����left/right subtreeһ����combination����Ϊ��f(0) * f(2) = 2

��2Ϊ�ڵ㣬��left subtreeֻ��Ϊ1��right subtreeֻ��Ϊ2��f(1) * f(1) = 1

��3Ϊ�ڵ㣬��left subtree��1, 2�����ڵ㣬right subtree��0���ڵ㣺f(2)*f(0) = 2

�ܽ���ɣ�
f(0) = 1
f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-2)*f(1) + f(n-1)*f(0)

i=2, count[2]=count[0]*count[1] // 1 is root
            + count[1]*count[0] // 2 is root

i=3, count[3]=count[0]*count[2] // 1 is root
            + count[1]*count[1] // 2 is root
            + count[2]*count[0] // 3 is root

i=4, count[4]=count[0]*count[3] // 1 is root
            + count[1]*count[2] // 2 is root
            + count[2]*count[1] // 3 is root
            + count[3]*count[0] // 4 is root

 */



public class N96_UniqueBinarySearchTrees {
	//0 ms
    public int numTrees(int n) {
        int[] catalan = new int[n+1];
        catalan[0]=1;
        for(int i=1; i<=n; i++){
        	for(int j=0;j<i;j++){
        		catalan[i] += catalan[j] * catalan[i-j-1];
        	}
        }
    	
    	return catalan[n];
    }
}
