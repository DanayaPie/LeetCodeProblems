package codingProblems.Java;

public class SortArrayByParity {
    /*-
        Ways:
            1. Two pointers: look for even nums
            2. Two pointers: compare left and right ends
     */

    static public void main(String[] args) {

        int[] nums = {1, 2, 0, 4, 9, 8};

        sortArrayByParity(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    // 1. Look for even nums
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

    // 2. compare left and right ends
//    private static int[] sortArrayByParity(int[] nums) {
//
//        int right = nums.length - 1;
//        for (int left = 0; left < nums.length; left++) {
//            if (left < right) {
//                if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
//                    int temp = nums[left];
//                    nums[left] = nums[right];
//                    nums[right] = temp;
//                } else if (nums[left] % 2 == 0) {
//                    left++;
//                } else if (nums[right] % 2 != 0) {
//                    right++;
//                }
//            }
//        }
//        return nums;
    }
}
