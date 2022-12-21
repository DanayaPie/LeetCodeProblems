package codingProblems.Java;

public class HeightChecker {

    /*-
        Logic:
            - use count sort
        Ways:
            1. compare input w new array -> TC: O(n + k) SC: O(n + k), k = range of input
            2. compare input w count[] from count sort -> TC: O(n) SC: O(n)
     */
    public static void main(String[] args) {
        int[] heights = {1, 2, 2, 3, 2};

        System.out.println(heightChecker(heights));
    }

    // 1. compare input w new array
//    private static int heightChecker(int[] heights) {
//        int outOfOrder = 0;
//        int[] count = new int[101]; // range of 1 - 100
//        int[] sortedH = new int[heights.length];
//
//        // counting the distinct height values into count[]
//        for (int i = 0; i < heights.length; i++) {
//            count[heights[i]]++;
//        }
//
//        // set count[] to contain last index of each element
//        for (int i = 1; i <= count.length - 1; i++) {
//            count[i] += count[i - 1];
//        }
//
//        // build sortedH[] in reverse of heights[]
//        for (int i = heights.length - 1; i >= 0; i--) {
//            sortedH[count[heights[i]] - 1] = heights[i];
//            count[heights[i]]--;
//        }
//
//        // compare 2 arrays
//        for (int i = 0; i < heights.length; i++) {
//            if (heights[i] != sortedH[i]) {
//                outOfOrder++;
//            }
//        }
//
//        return outOfOrder;
//    }

    // 2. compare input w count[] from count sort
    private static int heightChecker(int[] heights) {
        int outOfOrder = 0;
        int[] count = new int[101]; // range of 1 - 100

        // counting the distinct height values into count[]
        for (int i = 0; i < heights.length; i++) {
            count[heights[i]]++;
        }

        /*  Compare every non-zero element with input
                - count[i] - 1 each while loop til it is zero, then back to for loop
                - j - 1 each while loop
                - mismatch will increase outOfOrder by 1
         */
        for (int i = 1, j = 0; i < count.length && j < heights.length; i++) {
            while (count[i] > 0){
                if (i != heights[j]) {
                    outOfOrder++;
                }
                j++;
                count[i]--;
            }
        }

        return outOfOrder;
    }
}
