package codingProblems.Java;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {

        String s = "(1+(4+5+2)-3)+(6+8)";

        System.out.println(calculate(s));
    }

    /**
     * Stack
     * TC: O(n)
     * SC: O(n), worst case stack hold all ele
     */
    public static int calculate(String s) {

        int res = 0;
        int currentNum = 0;
        int sign = 1;
        Stack<Integer> holdStack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');

            } else if (ch == '+') {
                res += sign * currentNum;
                currentNum = 0; // reset currentNum
                sign = 1;

            } else if (ch == '-') {
                res += sign * currentNum;
                currentNum = 0; // reset currentNum
                sign = -1;

            } else if (ch == '(') {
                holdStack.push(res);
                holdStack.push(sign);
                res = 0;
                sign = 1;

            } else if (ch == ')') {
                res += sign * currentNum;
                currentNum = 0;

                res *= holdStack.pop(); // set res based on sigh, top ele
                res += holdStack.pop(); // add val to res, now top ele
            }
        }

        // last calculation
        res += sign * currentNum;

        return res;
    }
}
