package codingProblems.Java;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height));
    }

    /**
     * Sliding Window
     * TC: O(n)
     */
    private static int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;
        int lEnd = 0;

        for (int rEnd = 1; rEnd < height.length; rEnd++) {

            int minHeight = Math.min(height[lEnd], height[rEnd]);
            int currentArea = (rEnd - lEnd) * minHeight;
            maxArea = Math.max(maxArea, currentArea);

            if (height[lEnd] < height[lEnd + 1]) {

                lEnd++;
            }
        }

        return maxArea;
    }

    /**
     * Brute Force
     * TC: O(n^2)
     */
//    private static int maxArea(int[] height) {
//
//        int maxArea = 0;
//
//        for (int i = 0; i < height.length; i++){
//
//            for (int j = i + 1; j < height.length; j++) {
//
//                int minHeight = Math.min(height[i], height[j]);
//                int currentArea = (j - i) * minHeight;
//
//                maxArea = Math.max(currentArea, maxArea);
//            }
//        }
//
//        return maxArea;
//    }
}
