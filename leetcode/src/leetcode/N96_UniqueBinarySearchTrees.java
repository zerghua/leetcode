package leetcode;
/*
 * https://en.wikipedia.org/wiki/Catalan_number
 定义f(n)为unique BST的数量，以n = 3为例：

构造的BST的根节点可以取{1, 2, 3}中的任一数字。

如以1为节点，则left subtree只能有0个节点，而right subtree有2, 3两个节点。
所以left/right subtree一共的combination数量为：f(0) * f(2) = 2

以2为节点，则left subtree只能为1，right subtree只能为2：f(1) * f(1) = 1

以3为节点，则left subtree有1, 2两个节点，right subtree有0个节点：f(2)*f(0) = 2

总结规律：
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
