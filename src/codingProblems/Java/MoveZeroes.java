package codingProblems.Java;

public class MoveZeroes {

    /*-
        Logic:
            - Two pointers
     */
    public static void main(String[] args) {

        int[] nums = {2, 1};

        moveZeroes(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void moveZeroes(int[] nums) {

        int lastZeroPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastZeroPos];
                nums[lastZeroPos] = temp;
                lastZeroPos++;

            }
        }
    }
}
