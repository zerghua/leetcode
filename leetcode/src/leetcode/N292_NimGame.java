package leetcode;

/**
 * Created by Hua on 5/18/2016.

 You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner.
 You will take the first turn to remove the stones.

 Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

 For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

 */
public class N292_NimGame {
    // Adobe
    // win when there is 1,2,3, 5,6,7
    // only lose there is 4, 8 and etc...
    // 0ms
    public boolean canWinNim(int n) {
        if(n%4 == 0) return false;
        return true;
    }
}
