package codingProblems.Java;

public class MaxAveSubArrayOne {

    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println(findMaxAverage(nums, k));
    }

    /*
        Sliding Window - improve
        TC: O(n)
     */
    public static double findMaxAverage(int[] nums, int k) {

        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int maxSum = currentSum;

        for (int i = k; i < nums.length; i++) {

            currentSum -= nums[i - k]; // subtract most left element
            currentSum += nums[i]; // add current element

            maxSum = Math.max(currentSum, maxSum);
        }

        return (double) maxSum / k;
    }

    /*
        Sliding Window
        TC: O(n)
     */
//    public static double findMaxAverage(int[] nums, int k) {
//
//        double maxSum = Double.NEGATIVE_INFINITY;
//        double currentSum = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//
//            currentSum += nums[i];
//
//            if (i >= k - 1) {
//
//                maxSum = Math.max(currentSum, maxSum);
//
//                // subtract left most value from currentSum
//                currentSum -= nums[i - (k - 1)];
//            }
//        }
//        return maxSum / k;
//    }

    /*
        Brute Force
        TC: O(nk)
     */
//    public static double findMaxAverage(int[] nums, int k) {
//
//        double maxSum = Double.MIN_VALUE;
//
//        for (int i = 0; i <= nums.length - k; i++) {
//
//            double sum = 0;
//
//            for (int j = i; j < i + k; j++) {
//                 sum += nums[j];
//            }
//
//            maxSum = Math.max(sum, maxSum);
//        }
//
//        return maxSum / k;
//    }
}
