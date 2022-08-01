package codingProblems.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 11, 15, 3};
        int target = 5;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    // HashMap
    public static int[] twoSum(int[] nums, int target) {

        int first = -1;
        int sec = -1;

        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            first = i;
            if (numsMap.containsKey(target - nums[i])) {
                sec = numsMap.get(target - nums[i]);
                return new int[]{first, sec};
            }
            numsMap.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

//    // double for loop - O(n^2)
//    public int[] twoSum(int[] nums, int target) {
//        int n = nums.length;
//
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j < n; j++) {
//
//                int sum = nums[j] + nums[j - i];
//                if (sum == target) {
//                    return new int[]{j - i, j};
//                }
//            }
//        }
//        return null;
//    }
}
