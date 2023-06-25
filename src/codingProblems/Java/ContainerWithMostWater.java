package codingProblems.Java;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height));
    }

    /*
        Two Pointers
        TC: O(n)
     */
    private static int maxArea(int[] height) {

        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            int minHeight = Math.min(height[left], height[right]);
            int currentArea = (right - left) * minHeight;
            maxArea = Math.max(currentArea, maxArea);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }

    /*
        Brute force
        TC: O(n^2)
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
