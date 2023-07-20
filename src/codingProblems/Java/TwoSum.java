package codingProblems.Java;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {5, 6, 1, 4};
        int target = 5;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /**
     * Hash Maps
     * TC: O(n)
     * SC: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(nums[i])) {

                return new int[] {map.get(nums[i]), i};
            } else {

                map.put(complement, i);
            }
        }

        return new int[]{-1, -1};
    }


    /**
     * Brute Force
     * TC: O(n^2)
     */
//    public static int[] twoSum(int[] nums, int target) {
//
//        for (int i = 0; i < nums.length; i++) {
//
//            int complement = target - nums[i];
//
//            for (int j = i + 1; j < nums.length; j++) {
//
//                if (nums[j] == complement) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//
//        return new int[]{-1, -1};
//    }
}
