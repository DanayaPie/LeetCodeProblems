package codingProblems.Java;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {

        int[] nums = {-1,2,1,-4};
        int target = 1;

        System.out.println(threeSumClosest(nums, target));
    }

    /*
        2 pointers
        TC:
        SC:
     */
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res = 0;
        int closestDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int threeSum = nums[i] + nums[left] + nums[right];

                if (threeSum == target) {
                    return target;
                } else {

                    int diff = Math.abs(threeSum- target);
                    if (threeSum < target) {

                        if (diff < closestDiff) {
                            closestDiff = diff;
                            res = threeSum;
                        }
                        left++;
                    } else if (threeSum > target) {

                        if (diff < closestDiff) {
                            closestDiff = diff;
                            res = threeSum;
                        }
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
