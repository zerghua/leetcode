package leetcode;

/**
 * Created by Hua on 10/25/2016.

 Given a nested list of integers represented as a string, implement a parser to deserialize it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Note: You may assume that the string is well-formed:

 String is non-empty.
 String does not contain white spaces.
 String contains only digits 0-9, [, - ,, ].

 Example 1:

 Given s = "324",

 You should return a NestedInteger object which contains a single integer 324.

 Example 2:

 Given s = "[123,[456,[789]]]",

 Return a NestedInteger object containing a nested list with 2 elements:

 1. An integer containing value 123.
 2. A nested list containing two elements:
 i.  An integer containing value 456.
 ii. A nested list with one element:
 a. An integer containing value 789.

 https://discuss.leetcode.com/topic/54270/an-java-iterative-solution/2

 */
import java.util.*;
public class N385_MiniParser {
    // Airbnb
    // 25 ms 57 / 57 test cases passed.
    public class Solution {
        public NestedInteger deserialize(String s) {
            if(s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));

            Stack<NestedInteger> stack = new Stack();
            NestedInteger ret = new NestedInteger();
            stack.push(ret);
            int left=1;
            char[] a = s.toCharArray();
            for(int i=1;i<a.length;i++){
                if(a[i] == '['){
                    NestedInteger newNI = new NestedInteger();
                    stack.peek().add(newNI);
                    stack.push(newNI);
                    left = i+1;
                }else if(a[i] == ',' || a[i] == ']'){
                    if(i>left){
                        int val = Integer.valueOf(s.substring(left,i));
                        stack.peek().add(new NestedInteger(val));
                    }
                    if(a[i] == ']') stack.pop();
                    left = i+1;
                }
            }
            return ret;
        }
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger(){};

        // Constructor initializes a single integer.
        public NestedInteger(int value){};

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger(){return false;}

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){return 1;}

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value){}

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){}

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){return null;}
    }
}
