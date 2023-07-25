package codingProblems.Java;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {

        String s = "abbaca";

        System.out.println(removeDuplicates(s));
    }

    /**
     * Stack
     * TC: O(n)
     * SC: O(n)
     */
    public static String removeDuplicates(String s) {

        StringBuilder res = new StringBuilder();
        Stack<Character> charStack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!charStack.isEmpty() && c == charStack.peek()) {
                charStack.pop();
            } else {
                charStack.push(c);
            }
        }

        while (!charStack.isEmpty()) {
            res.insert(0, charStack.pop());
        }

        return res.toString();
    }
}
