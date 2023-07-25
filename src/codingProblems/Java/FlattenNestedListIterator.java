package codingProblems.Java;

import java.util.*;

public class FlattenNestedListIterator {

    public static void main(String[] args) {

        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger(1));
        nestedList.add(new NestedInteger(2));
        nestedList.add(new NestedInteger(Arrays.asList(new NestedInteger(3), new NestedInteger(4))));
        nestedList.add(new NestedInteger(Arrays.asList(new NestedInteger(5))));

        NestedIterator nestedIterator = new NestedIterator(nestedList);

        while (nestedIterator.hasNext()) {
            System.out.print(nestedIterator.next() + ", ");
        }
    }

    /**
     * Stack
     * TC: O(n), hasNest() and next() take O(1) time using stack operation
     * SC: O(n)
     */
    public static class NestedIterator implements Iterator<Integer> {

        // stack to keep track of nested list that are yet to visited
        private Stack<NestedInteger> toBeSeenStack;

        public NestedIterator(List<NestedInteger> nestedList) {

            toBeSeenStack = new Stack<>(); // initialize the stack

            for (int i = nestedList.size() - 1; i >= 0; i--) {
                toBeSeenStack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {

            if (hasNext()) {
                return toBeSeenStack.pop().getInteger();
            }

            return null;
        }

        @Override
        public boolean hasNext() {

            while (!toBeSeenStack.isEmpty()) {

                NestedInteger topStack = toBeSeenStack.peek();

                if (topStack.isInteger()) {
                    return true;
                }

                toBeSeenStack.pop();

                // get the nestedList from the top of stack
                List<NestedInteger> nestedList = topStack.getList();
                for (int i = nestedList.size() - 1; i >= 0; i--) {
                    toBeSeenStack.push(nestedList.get(i));
                }
            }

            return false;
        }
    }

    /**
     * NestedInteger Object
     */
    public static class NestedInteger {
        // Fields
        private Integer integer;
        private List<NestedInteger> list;

        // Constructor for integer value
        public NestedInteger(int value) {
            this.integer = value;
            this.list = null;
        }

        // Constructor for nested list
        public NestedInteger(List<NestedInteger> nestedList) {
            this.list = nestedList;
            this.integer = null;
        }

        // Check if this NestedInteger holds an integer
        public boolean isInteger() {
            return integer != null;
        }

        // Get the integer value if it holds an integer
        public Integer getInteger() {
            return integer;
        }

        // Get the nested list if it holds a list
        public List<NestedInteger> getList() {
            return list;
        }
    }
}
