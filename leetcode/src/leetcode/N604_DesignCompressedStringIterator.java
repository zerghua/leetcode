package leetcode;

/**
 * Created by Hua on 7/11/2017.

 Design and implement a data structure for a compressed string iterator.
 It should support the following operations: next and hasNext.

 The given compressed string will be in the form of each letter followed by a positive integer
 representing the number of this letter existing in the original uncompressed string.

 next() - if the original string still has uncompressed characters, return the next letter;
 Otherwise return a white space.
 hasNext() - Judge whether there is any letter needs to be uncompressed.

 Note:
 Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted
 across multiple test cases. Please see here for more details.

 Example:

 StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");   // L1 e2 t1 C1 o1 d1 e1

 iterator.next(); // return 'L'
 iterator.next(); // return 'e'
 iterator.next(); // return 'e'
 iterator.next(); // return 't'
 iterator.next(); // return 'C'
 iterator.next(); // return 'o'
 iterator.next(); // return 'd'
 iterator.hasNext(); // return true
 iterator.next(); // return 'e'
 iterator.hasNext(); // return false
 iterator.next(); // return ' '


 Test cases:
 ["StringIterator","next","next","next","next","next","next","hasNext","next","hasNext"]
 [["a1234567890b1234567890"],[],[],[],[],[],[],[],[],[]]


 */

import java.util.*;
public class N604_DesignCompressedStringIterator {
    // Google (Premium)
    // solution from editorial
    public class StringIterator {
        String res;
        int ptr = 0, num = 0;
        char ch = ' ';
        public StringIterator(String s) {
            res = s;
            // new ArrayList(Arrays.asList(s.toCharArray())).iterator();
        }
        public char next() {
            if (!hasNext())
                return ' ';
            if (num == 0) {
                ch = res.charAt(ptr++);
                while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
                    num = num * 10 + res.charAt(ptr++) - '0';
                }
            }
            num--;
            return ch;
        }
        public boolean hasNext() {
            return ptr != res.length() || num != 0;
        }
    }


    // my solution
    // 169 / 169 test cases passed.
    // 134 ms
    // dynamic update list
    public class StringIterator2 {
        class Node{
            char c;
            long count;
            Node(char c, long count){
                this.c = c;
                this.count = count;
            }
        }

        LinkedList<Node> list;
        public StringIterator2(String compressedString) {
            list = new LinkedList();

            // put each char of string into linkedlist
            int i = 0;
            while(i < compressedString.length()){
                char c = compressedString.charAt(i);
                int start = ++i;
                while(i < compressedString.length() && compressedString.charAt(i) >= '0' && compressedString.charAt(i) <= '9') i++;
                int num = Integer.parseInt(compressedString.substring(start, i));
                list.add(new Node(c, num));
            }
        }

        public char next() {
            if(hasNext()) {
                char ret = list.get(0).c;
                list.get(0).count--;
                if(list.get(0).count == 0) list.removeFirst();
                return ret;
            }
            return ' ';
        }

        public boolean hasNext() {
            return !list.isEmpty();
        }
    }
}
