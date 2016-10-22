package leetcode;

/**
 * Created by Hua on 5/22/2016.

 Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner
 as shown in the figure.


 Assume that the total area is never beyond the maximum possible value of int.

        (C,D)
 (A,B)

        (G,H)
 (E,F)

 */
public class N223_RectangleArea {
    // 4 ms
    // math
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // no overlap
        if(G<A || C<E || D<F || H<B) return (C-A)*(D-B) + (G-E)*(H-F);

        //overlap
        int left=Math.max(A,E);
        int right=Math.min(C,G);
        int top = Math.min(D,H);
        int bottom = Math.max(B,F);

        return (C-A)*(D-B) + (G-E)*(H-F) - (right-left)*(top-bottom);
    }

}
