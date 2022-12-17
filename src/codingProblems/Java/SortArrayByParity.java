package codingProblems.Java;

public class SortArrayByParity {
    /*-
        Logic:
            - Two pointers: look for even nums
     */

    static public void main(String[] args) {

        int[] nums = {1, 2, 0, 4, 9, 8};

        sortArrayByParity(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static int[] sortArrayByParity(int[] nums) {

        int lastOddPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[lastOddPos];
                nums[lastOddPos] = temp;
                lastOddPos++;
            }
        }
        return nums;
    }
}
