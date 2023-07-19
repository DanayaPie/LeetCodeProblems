package codingProblems.Java;

public class MinSizeSubArraySum {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int target = 11;

        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * Sliding Window - dynamic
     * TC: O(n)
     */
    public static int minSubArrayLen(int target, int[] nums) {

        int minLen = Integer.MAX_VALUE;
        int currentSum = 0;
        int lEnd = 0;

        for (int rEnd = 0; rEnd < nums.length; rEnd++) {

            currentSum += nums[rEnd];

            while (currentSum >= target) {

                minLen = Math.min(minLen, rEnd - lEnd + 1);

                currentSum -= nums[lEnd];
                lEnd++;
            }
        }

        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }

    /**
     * Brute Force
     * TC: O(n^2)
     */
//    public static int minSubArrayLen(int target, int[] nums) {
//
//        int minLen = Integer.MAX_VALUE;
//
//        for (int i = 0; i < nums.length; i++) {
//
//            int currentSum = 0;
//
//            for (int j = i; j < nums.length; j++) {
//
//                currentSum += nums[j];
//
//                if (currentSum >= target) {
//
//                    minLen = Math.min(minLen, j - i + 1);
//                }
//            }
//
//        }
//
//        return minLen != Integer.MAX_VALUE ? minLen : 0;
//    }
}
