package codingProblems;

public class FindNumbersWithEvenNumOfDigits {

    public static void main(String[] args) {
        int[] nums = {1325, 12, 125};

        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            int digit = 0;
            digit =  (int)Math.log10(nums[i]) + 1;

            if (digit % 2 == 0) {
                max++;
            }
        }
        return max;
    }
}
