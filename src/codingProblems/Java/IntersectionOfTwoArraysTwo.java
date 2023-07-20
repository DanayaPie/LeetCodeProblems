package codingProblems.Java;


import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArraysTwo {

    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    /**
     * Two Pointers - ArrayList
     * TC: O(n log n)
     * SC: O(min(m, n), m and n are lengths of nums1 and nums2
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {

            if (nums1[p1] < nums2[p2]) {

                p1++;
            } else if (nums2[p2] < nums1[p1]) {

                p2++;
            } else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    /**
     * HashMap and ArrayList
     * TC: O(m + n), m and n are lengths of nums1 and nums2
     * SC: O(m + n)
     */
//    public static int[] intersect(int[] nums1, int[] nums2) {
//
//        HashMap<Integer, Integer> numsMap = new HashMap<>();
//
//        for (int i : nums1) {
//            numsMap.put(i, numsMap.getOrDefault(i, 0) + 1);
//        }
//
//        ArrayList<Integer> resList = new ArrayList<>();
//
//        for (int i : nums2) {
//
//            if (numsMap.containsKey(i) && numsMap.get(i) != 0) {
//                resList.add(i);
//                numsMap.put(i, numsMap.getOrDefault(i, 0) - 1);
//            }
//        }
//
//        int[] res = new int[resList.size()];
//        for (int i = 0; i < resList.size(); i++) {
//            res[i] = resList.get(i);
//        }
//
//        return res;
//    }
}
