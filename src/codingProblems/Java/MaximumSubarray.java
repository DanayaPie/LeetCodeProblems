package codingProblems.Java;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, -1, -3, -4, -1, -2, -1, -5, -4};

        System.out.println(maxSubArray(nums));
    }

    /**
     * Sliding Window - dynamic
     * TC: O(n)
     */
    public static int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);

            while (currentSum < 0) {

                currentSum -= nums[left];
                left++;
            }

        }

        return maxSum;
    }

    /**
     * Kadane's Algorithm
     * TC: O(n)
     */
//    public static int maxSubArray(int[] nums) {
//
//        int maxSum = Integer.MIN_VALUE;
//        int currentSum = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//
//            currentSum += nums[i];
//            maxSum = Math.max(currentSum, maxSum);
//
//            // reset currentSum to 0
//            if (currentSum < 0) {
//                currentSum = 0;
//            }
//        }
//
//        return maxSum;
//    }

    /**
     * Brute Force
     * TC: O(n^2)
     */
//    public static int maxSubArray(int[] nums) {
//
//        int maxSum = Integer.MIN_VALUE;
//
//        for (int i = 0; i < nums.length; i++) {
//
//                int currentSum = 0;
//
//            for (int j = i; j < nums.length; j++) {
//
//                currentSum += nums[j];
//                maxSum = Math.max(currentSum, maxSum);
//            }
//        }
//
//        return maxSum;
//    }
}
