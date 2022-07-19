package codingProblems;

public class MergeSortedArray {

    /*-
     * 2 pointers: compare last of nums1 and last of nums2
     ** use ternary operator
     */
    public static void main(String[] args) {

        // merge sorted array and stored it inside nums1
        int m = 5;
        int n = 3;

        // nums1.length == m + n
        // nums2.length == n
        int[] nums1 = {-4, -3, 0, 1, 3, 0, 0, 0};
        int[] nums2 = {-3, 3, 8};

        nums1 = mergeSortedArray(nums1, m, nums2, n);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    private static int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

        int pos1 = m - 1;
        int pos2 = n - 1;
        int posFinal = m + n - 1;

        while (pos2 >= 0) {

            if (pos1 >= 0) {
                nums1[posFinal--] = nums1[pos1] > nums2[pos2] ? nums1[pos1--] : nums2[pos2--];
            } else {
                nums1[posFinal--] = nums2[pos2--];
            }
        }

        return nums1;
    }
}
