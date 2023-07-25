package codingProblems.Java;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        String s = "[{}]";

        System.out.println(isValid(s));
    }

//     // fast Switch
//     public static boolean isValid(String s) {
//       if ((s.length() & 1) == 1) return false;
//       else {
//         Deque<Character> p = new ArrayDeque<>(s.length());
//         for (int i = 0; i < s.length(); i++)
//           switch (s.charAt(i)) {
//             case '(': p.push(')'); break;
//             case '{': p.push('}'); break;
//             case '[': p.push(']'); break;
//             case ')': case '}': case ']': if (p.isEmpty() || p.pop() != s.charAt(i)) return false;
//           }
//         return p.isEmpty();
//       }
//     }

    /**
     * Stack
     * TC: O(n)
     * SC: O(n), from O(n/2) stack
     */
    public static boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> charStack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '[') {
                charStack.push(']');
            } else if (c == '{') {
                charStack.push('}');
            } else if (c == '(') {
                charStack.push(')');
            } else if (charStack.isEmpty() || charStack.pop() != c) {
                return false;
            }
        }

        return true;
    }

    /**
     * Stack with HashMap
     * TC: O(n)
     * SC: O(n) from stack usage, neglect constant hashmap space
     */
//    public static boolean isValid(String s) {
//
//        if (s.length() % 2 != 0) {
//            return false;
//        }
//
//        Stack<Character> charStack = new Stack<>();
//
//        HashMap<Character, Character> parenthesesMap = new HashMap<>();
//        parenthesesMap.put(']', '[');
//        parenthesesMap.put('}', '{');
//        parenthesesMap.put(')', '(');
//
//        for (char c : s.toCharArray()) {
//
//            if (!parenthesesMap.containsKey(c)) {
//
//                charStack.push(c);
//            } else {
//                if (!charStack.isEmpty()) {
//
//                    if (charStack.peek() == parenthesesMap.get(c)) {
//                        charStack.pop();
//                    } else {
//                        return false;
//                    }
//                } else {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
}
