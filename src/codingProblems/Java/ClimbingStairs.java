package codingProblems.Java;

public class ClimbingStairs {

    /*-
    Logic:
        1. Recursive - top down --> Time: O(2^n) ; Space: O(n)
        2. Dynamic Programming - bottom up --> Time: O(n), Space: O(n)
        3. Dynamic Programming Optimized Space - bottom up --> Time: O(n), Space: O(1)
 */
    public static void main(String[] args) {

        int n = 8;

        System.out.println(climbStairs(n));
    }

    // DP Optimized
    public static int climbStairs(int n) {

        int prev1 = 1;
        int prev2 = 2;

        if (n <= 3) {
            return n;
        }

        for (int i = 3; i <= n; i++) {
            int sum = prev1 + prev2;

            prev1 = prev2;
            prev2 = sum;
        }

        return prev2;
    }

//    // DP
//    public static int climbStairs(int n) {
//
//        if (n <= 3) {
//            return n;
//        }
//
//        int[] res = new int[n + 1];
//        res[1] = 1;
//        res[2] = 2;
//
//        for (int i = 3; i <= n; i++) {
//            res[i] = res[n - 1] + res[n - 2];
//        }
//
//        return res[n];
//    }

//    // Recursive
//    public static int climbStairs(int n) {
//
//        int res = 0;
//        if (n >= 1 && n <= 2) {
//            return n;
//        }
//
//        res = climbStairs((n-1)) + climbStairs(n-2);
//        return res;
//    }
}
