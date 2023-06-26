package codingProblems.Java;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
    }

    /*
        Sliding Window
        TC: O(n)
     */
    public static int maxSubArray(int[] nums) {

        int maxSum = nums[1];
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);

            // reset currentSum if it is less than 0
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    /*
        Brute Force
        TC: O(n^2)
     */
//    public static int maxSubArray(int[] nums) {
//
//        int maxSum = Integer.MIN_VALUE;
//
//        for (int i = 0; i < nums.length; i++) {
//
//            int sum = 0;
//
//            for (int j = i; j < nums.length; j++) {
//
//                sum += nums[j];
//                maxSum = Math.max(sum, maxSum);
//            }
//        }
//
//        return maxSum;
//    }
}
