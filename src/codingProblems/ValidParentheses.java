package codingProblems;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        String s = "[{]}]";

        System.out.println(isValid(s));
    }

    // fast Stack
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
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

//     // works but slow! - mine
//     public static boolean isValid(String s) {

//         Stack<Character> stack = new Stack<>();

//         HashMap<Character, Character> hm = new HashMap<>();
//         hm.put(')', '(');
//         hm.put(']', '[');
//         hm.put('}', '{');

//         if (s.length() % 2 != 0) {
//             return false;
//         }

//         for (int i = 0; i < s.length(); i++) {

//             if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
//                 stack.add(s.charAt(i));

//             } else if (!stack.isEmpty()) {
//                 char top = stack.peek();

//                 System.out.println(top + " == " + hm.get(s.charAt(i)));

//                 if (top == hm.get(s.charAt(i))) {
//                     stack.pop();

//                 } else {
//                     return false;
//                 }
//             } else {
//                 return false;
//             }
//         }

//         if (stack.isEmpty()){
//             return true;
//         }

//         return false;
//     }
}
