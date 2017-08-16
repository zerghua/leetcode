package leetcode;
import java.util.*;

/**
 * Created by Hua on 6/4/2016.

 Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also
 be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements
 returned by next should be: [1,1,2,1,1].

 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements
 returned by next should be: [1,4,6].

  Your NestedIterator object will be instantiated and called as such:
  NestedIterator i = new NestedIterator(nestedList);
  while (i.hasNext()) v[f()] = i.next();

 */


public class N341_FlattenNestedListIterator {
    // Google, Facebook
    // iterator design, store iterator in stack.
    // 44 / 44 test cases passed.   on 8/16/2017
    // 6 ms
    public class NestedIterator implements Iterator<Integer> {
        NestedInteger nextInt;
        Stack<Iterator<NestedInteger>> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<Iterator<NestedInteger>>();
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return nextInt != null ? nextInt.getInteger() : null; //Just in case
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (!stack.peek().hasNext()) stack.pop();
                else if ((nextInt = stack.peek().next()).isInteger()) return true;
                else stack.push(nextInt.getList().iterator());
            }
            return false;
        }
    }



    // recursion solution,
    // not right, should use iterator attribute rather than store all items in list
    // 44 / 44 test cases passed.
    // 29 ms
    public class NestedIterator2 implements Iterator<Integer> {
        // remember to new a list, or will get null pointer exception.
        private ArrayList<Integer> list = new ArrayList<>();

        public void getNumberFromNestedList(List<NestedInteger> nestedList){
            for(NestedInteger i: nestedList){
                if(i.isInteger()) list.add(i.getInteger());
                else getNumberFromNestedList(i.getList());
            }
        }

        public NestedIterator2(List<NestedInteger> nestedList) {
            getNumberFromNestedList(nestedList);
        }

        public Integer next() {
            return list.remove(0);
        }

        public boolean hasNext() {
            return !list.isEmpty();
        }
    }



    // iterative solution
    // Assumption: will always call hasNext first and then next.
    // 12 ms
    public class NestedIterator3{
        private ArrayList<NestedInteger> list;

        public NestedIterator3(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            for(NestedInteger item: nestedList){
                list.add(item);
            }
        }

        public Integer next() {
            return list.remove(0).getInteger();
        }

        public boolean hasNext() {
            while(!list.isEmpty()) {
                NestedInteger item = list.get(0);
                if (item.isInteger()) return true;

                list.remove(0);
                for (int i = item.getList().size() - 1; i >= 0; i--) {
                    list.add(0, item.getList().get(i));
                }
            }
            return false;
        }
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
