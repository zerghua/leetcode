package leetcode;
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


https://en.wikipedia.org/wiki/Catalan_number

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

i=1
catalan[0] = 1
catalan[1] = catalan[0] * catalan[0]  === 1
catalan[2] = catalan[0] * catalan[1] + catalan[1] * catalan[0]  === 2
catalan[3] = catalan[0] * catalan[2] + catalan[1] * catalan[1] + catalan[2] * catalan[0] === 5
catalan[3] = catalan[0] * catalan[3] +
             catalan[1] * catalan[2] +
             catalan[2] * catalan[1] +
             catalan[3] * catalan[0]   === 5 + 2 + 2 + 5 = 14
 */


public class N96_UniqueBinarySearchTrees {
	//0 ms
    // F(i, n) = G(i) * G(n-i-1)	0 <= i < n
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
