package codingProblems.Java;

public class ClimbingStairs {

    /*-
    Logic:
        1. Recursive - top down --> Time: O(2^n) ; Space: O(n)
        2. Dynamic Programming - bottom up --> Time: O(n), Space: O(n)
        3. Dynamic Programming Optimized Space - bottom up --> Time: O(n), Space: O(1)
 */
    public static void main(String[] args) {

        int n = 5;

        System.out.println(climbStairs(n));
    }


    /**
     * DP - bottom up, working from bottom of tree (from n)
     * TC: O(n)
     * SC: O(1)
     */
//    public static int climbStairs(int n) {
//
//        if (n == 1 || n == 2) {
//            return n;
//        }
//
//        int prev1 = 1;
//        int prev2 = 1;
//
//        for (int i = 0; i < n - 1; i++) {
//
//            int temp = prev1;
//            prev1 = prev1 + prev2;
//            prev2 = temp;
//        }
//
//        return prev1;
//    }

    /**
     * Memoization - Recursion
     * TC: O(n), calculate and store result for each 1 to n once
     * SC: O(n), memoization table
     */
    public static int climbStairs(int n) {

        // initialize memoization table for each possible steps, n, and number of ways, memo[n]
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    private static int climbStairsMemo(int n, int[] memo) {

        if (n == 1 || n == 2) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        // recursively call climbStairsMemo until n == 1 or n == 2 or memo[n] exist in memo table
        memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }


    /**
     * Brute Force - Recursion
     * TC: O(2^n), each recursion call, the function calls itself twice forming binary tree
     * SC: O(n), determine by the depth of recursion stack
     */
//    public static int climbStairs(int n) {
//
//        if (n == 1 || n == 2) {
//            return n;
//        }
//
//        int ways = 0;
//        ways = climbStairs(n - 1) + climbStairs(n - 2); // climbing 1 + 2 steps at a time
//
//        return ways;
//    }
}
