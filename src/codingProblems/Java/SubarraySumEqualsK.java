package codingProblems.Java;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 2, 1};
        int k = 3;

        System.out.println(subarraySum(nums, k)); // 4
    }

    /**
     * HashMap - use to keep track of count (number of subarray) with sum of diff
     * TC: O(n)
     * SC: O(n)
     */
    public static int subarraySum(int[] nums, int k) {

        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for (int num : nums) {

            currentSum += num;
            int diff = currentSum - k;

            if (prefixSum.containsKey(diff)) {

                count += prefixSum.get(diff);
            }

            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    /**
     * Brute Force
     * TC: O(n^2)
     */
//    public static int subarraySum(int[] nums, int k) {
//
//        int count = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//
//            int sum = 0;
//
//            for (int j = i; j < nums.length; j++) {
//
//                sum += nums[j];
//
//                if (sum == k) {
//                    count++;
//                    continue;
//                }
//            }
//        }
//
//        return count;
//    }
}
