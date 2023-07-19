package codingProblems.Java;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        int[] prices = {7, 2, 1, 6, 5};

        System.out.println(maxProfit(prices));
    }

    /**
     * Two Pointers - min and current prices
     * TC: O(n)
     */
    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < min) {

                min = prices[i];
            } else {

                maxProfit = Math.max(maxProfit, prices[i] - min);
            }

        }

        return maxProfit;
    }

    /**
     * Brute Force
     * TC: O(n^2)
     */
//    public static int maxProfit(int[] prices) {
//
//        int maxProfit = 0;
//
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i; j < prices.length; j++) {
//
//                if (prices[j] > prices[i]) {
//
//                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
//                }
//            }
//        }
//
//        return maxProfit;
//    }
}
