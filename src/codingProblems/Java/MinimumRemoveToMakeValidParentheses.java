package codingProblems.Java;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {

        String s = "lee(t(c)o)de)";

        System.out.println(minRemoveToMakeValid(s));
    }

    /**
     * Stack
     * TC: O(2n) - worst case O(3n)
     * SC: O(n)
     */
    public static String minRemoveToMakeValid(String s) {

        StringBuilder res = new StringBuilder();
        Stack<Integer> indexStack = new Stack<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            char currentChar = chars[i];
            if (currentChar == '(') {
                indexStack.push(i);
            } else if (currentChar == ')') {

                if (!indexStack.isEmpty()) {
                    indexStack.pop();
                } else {
                    chars[i] = 0;
                }
            }
        }

        while (!indexStack.isEmpty()) {

            chars[indexStack.pop()] = 0;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                res.append(chars[i]);
            }
        }

        return res.toString();
    }


    /**
     * Stack with List
     * TC: O(2n) - worst case O(3n)
     * - slow due to time spend on removing and adding to ArrayList<>
     * SC: O(n)
     */
//    public static String minRemoveToMakeValid(String s) {
//
//        Stack<Integer> indexStack = new Stack<>();
//        List<Integer> toRemoveIndex = new ArrayList<>();
//        StringBuilder res = new StringBuilder();
//
//        char[] chars = s.toCharArray();
//
//        for (int i = 0; i < chars.length; i++) {
//
//            char currentChar = chars[i];
//
//            if (currentChar == '(') {
//                indexStack.push(i);
//            } else if (currentChar == ')') {
//
//                if (!indexStack.isEmpty()) {
//                    indexStack.pop();
//                } else {
//                    toRemoveIndex.add(i);
//                }
//            }
//        }
//
//        while (!indexStack.isEmpty()) {
//            toRemoveIndex.add(indexStack.pop());
//        }
//
//        for (int i = 0; i < chars.length; i++) {
//            if (!toRemoveIndex.contains(i)) {
//                res.append(chars[i]);
//            }
//        }
//
//        return res.toString();
//    }
}
