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

        // instantiate stack to store int or nestedInt that has not yet seen
        private Stack<NestedInteger> toBeSeenStack;

        public NestedIterator(List<NestedInteger> nestedList) {

            toBeSeenStack = new Stack<>(); // initialize toBeSeenStack

            for (int i = nestedList.size() - 1; i >= 0; i--) { // iterate in reverse bc stack is FILO
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

                List<NestedInteger> nestedList = topStack.getList();
                for (int i = nestedList.size() - 1; i >= 0; i--) { // iterate in reverse bc stack is FILO
                    toBeSeenStack.push(nestedList.get(i));
                }
            }

            return false;
        }
    }

    /**
     * Recursion
     * TC: O(n), can result in stack overflow in deep nested lists
     * SC: O(n)
     */
//    public static class NestedIterator implements Iterator<Integer> {
//
//        private List<Integer> flattenedList;
//        private int currentIndex;
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//
//            flattenedList = flatten(nestedList);
//            currentIndex = 0;
//        }
//
//        private List<Integer> flatten(List<NestedInteger> nestedList) {
//
//            List<Integer> res = new ArrayList<>();
//
//            for (NestedInteger nestedInt : nestedList) {
//
//                if (nestedInt.isInteger()) {
//                    res.add(nestedInt.getInteger());
//                } else {
//                    res.addAll(flatten(nestedInt.getList()));
//                }
//            }
//
//            return res;
//        }
//
//        @Override
//        public Integer next() {
//            return flattenedList.get(currentIndex++);
//        }
//
//        @Override
//        public boolean hasNext() {
//            return currentIndex < flattenedList.size();
//        }
//    }

    /*
     * NestedInteger Object
     *
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
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
