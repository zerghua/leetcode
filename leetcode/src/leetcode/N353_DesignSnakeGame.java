package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 7/23/2017.

 Design a Snake game that is played on a device with screen size = width x height.
 Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

 You are given a list of food's positions in row-column order. When a snake eats the food,
 its length and the game's score both increase by 1.

 Each food appears one by one on the screen. For example, the second food will not appear
 until the first food was eaten by the snake.

 When a food does appear on the screen, it is guaranteed that it will not appear on a
 block occupied by the snake.

 Example:

 Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake snake = new Snake(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake eats the first food and right after that,
 the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)




 */
public class N353_DesignSnakeGame {
    // google (Premium)
    // 539 / 539 test cases passed.
    // 329 ms
    public class SnakeGame {

        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1],
                     the second is at [1,0]. */

        LinkedList<int[]> list;
        HashSet<String> set;
        int row, col, index;
        LinkedList<int[]> food;

        public SnakeGame(int width, int height, int[][] food) {
            row = height; col = width; index = 0;
            set = new HashSet();
            set.add("0:0");
            list = new LinkedList();
            list.add(new int[]{0,0});
            this.food = new LinkedList();
            for(int[] p : food) this.food.add(new int[]{p[0], p[1]});
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            ArrayList<String> name = new ArrayList(Arrays.asList("R", "L", "D", "U"));

            int[] dir = dirs[name.indexOf(direction)];
            int new_i = list.get(0)[0] + dir[0], new_j = list.get(0)[1] + dir[1];

            // game over
            if(new_i < 0 || new_i >= row || new_j < 0 || new_j >= col) return -1;

            // trim tail
            int[] last = list.removeLast();
            set.remove(last[0] + ":" + last[1]);

            // move snake head
            if(set.contains(new_i + ":" + new_j)) return -1;  // to solve head bit tail case
            list.addFirst(new int[]{new_i, new_j});
            set.add(new_i + ":" + new_j);

            // undefined behavior when out of food but still in boundary
            // find food
            if(index < food.size() && new_i == food.get(index)[0] && new_j == food.get(index)[1]){
                index++;
                // add tail back
                list.addLast(last);
                set.add(last[0] + ":" + last[1]);
                return index;
            }

            return index;
        }
    }
}
