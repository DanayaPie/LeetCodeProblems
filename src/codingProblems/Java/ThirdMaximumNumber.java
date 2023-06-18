package codingProblems.Java;

public class ThirdMaximumNumber {

    /*-
        Logic:
            1. Iterate and compare first, sec, third max
     */

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};

        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        int firstMax = 0;
        int secMax = 0;
        int thirdMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == firstMax || nums[i] == secMax || nums[i] == thirdMax){
                continue;
            }
            if (firstMax == 0 || nums[i] > firstMax) {
                thirdMax = secMax;
                secMax = firstMax;
                firstMax = nums[i];


            } else if (secMax == 0 || nums[i] > secMax) {
                thirdMax = secMax;
                secMax = nums[i];

            } else if (thirdMax == 0 || nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
        }

        // if thirdMax == 0, return the firstMax
        return thirdMax == 0 ? firstMax : thirdMax;
    }
}
