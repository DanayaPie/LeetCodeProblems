package codingProblems;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 0};

        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int tempMax = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                tempMax++;
            } else {
                tempMax = 0;
            }
            max = Math.max(tempMax, max);
        }
        return max;
    }
}
