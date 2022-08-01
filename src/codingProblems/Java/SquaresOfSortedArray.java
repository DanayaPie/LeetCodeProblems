package codingProblems.Java;

import java.util.Arrays;

public class SquaresOfSortedArray {

    /*-
    Logics:
        1. square then Array.sort() => O(n^2 log n)
        2. compare absolute value - increase performance
        3. Two pointers - compare left and right elements => O(n)
    */

    public static void main(String[] args) {
        int[] nums = {-7, -3, 0, 3, 7, 10};

        System.out.println(Arrays.toString(sortedSquares(nums)));

    }

    // 2 pointers
    public static int[] sortedSquares(int[] nums) {

        int[] res = new int[nums.length];
        int resIndex = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                res[resIndex] = nums[left] * nums[left];
                left++;
            } else {
                res[resIndex] = nums[right] * nums[right];
                right--;
            }
            resIndex--;
        }
        return res;
    }

//    // Array.sort() method
//    public static int[] sortedSquares(int[] nums) {
//
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            res[i] = nums[i] * nums[i];
//        }
//        Arrays.sort(res);
//        return res;
//    }
}
