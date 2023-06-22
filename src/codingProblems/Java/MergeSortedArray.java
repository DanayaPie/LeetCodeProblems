package codingProblems.Java;

import java.util.Arrays;

public class MergeSortedArray {

    /*-
     * 2 pointers: compare last of nums1 and last of nums2
     ** use ternary operator
     */
    public static void main(String[] args) {

        // merge sorted array and stored it inside nums1, nums1.length = m + n
        int m = 5;
        int n = 3;

        // nums1.length == m + n
        // nums2.length == n
        int[] nums1 = {-4, -3, 0, 1, 3, 0, 0, 0};
        int[] nums2 = {-3, 3, 8};

        nums1 = mergeSortedArray(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));

    }

    private static int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int currentPos = nums1.length - 1;

        while (i > 0 || j > 0) {

            int nums1Val = nums1[i];
            int nums2Val = nums2[j];

            if (nums1Val >= nums2Val) {

                nums1[currentPos] = nums1Val;
                currentPos--;
                i--;
            } else if (nums2Val > nums1Val) {

                nums1[currentPos] = nums2Val;
                currentPos--;
                j--;
            }
        }

        return nums1;
    }
}
