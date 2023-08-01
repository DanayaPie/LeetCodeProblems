package codingProblems.Java;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {

        int n = 3;

        System.out.println(generateParentheses(n));
    }

    /**
     * Backtracking Recursion - StringBuilder
     * TC: O(2^(2n) * n), 2^(2n) is number of possible combination, n for time to copy parentheses combination to res
     * SC: O(2n), for StringBuilder
     */
    public static List<String> generateParentheses(int n) {

        List<String> res = new ArrayList<>();
        // utilize DFS to explore each branch before backtracking to different path
        backTracking(res, new StringBuilder(), 0, 0, n);

        return res;
    }

    private static void backTracking(List<String> res, StringBuilder currentParenteses, int openCount, int closeCount, int n) {

        if (currentParenteses.length() == n * 2) {
            res.add(currentParenteses.toString());
        }

        if (openCount < n) {
            backTracking(res, currentParenteses.append("("), openCount + 1, closeCount, n);
            // remove previously append char to maintain correct state of backtracking for other possible path
            currentParenteses.deleteCharAt(currentParenteses.length() - 1);
        }

        if (closeCount < openCount) {
            backTracking(res, currentParenteses.append(")"), openCount, closeCount + 1, n);
            // remove previously append char to maintain correct state of backtracking for other possible path
            currentParenteses.deleteCharAt(currentParenteses.length() - 1);
        }
    }


    /**
     * Backtracking Recursion - string concatenation
     * TC: O(2^n), 2 choices for position in generating string 2^(2n) possible combinations
     * SC: O(n)
     */
//    public static List<String> generateParentheses(int n) {
//
//        List<String> res = new ArrayList<>();
//        // utilize DFS to explore each branch before backtracking and trying another path
//        backtracking(res, "", 0, 0, n);
//
//        return res;
//    }
//
//    private static void backtracking(List<String> res, String currentParentehses, int openCount, int closeCount, int n) {
//
//        if (currentParentehses.length() == n * 2) {
//            res.add(currentParentehses);
//            return;
//        }
//
//        if (openCount < n) {
//            backtracking(res, currentParentehses + "(", openCount + 1, closeCount, n);
//        }
//
//        if (closeCount < openCount) {
//            backtracking(res, currentParentehses + ")", openCount, closeCount + 1, n);
//        }
//    }
}
