package codingProblems.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementOne {

    /*
        The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
        Given two distinct 0-indexed integer array, nums1 and nums2, where nums1 is subset of nums2 (all element in nums1 are in nums2).
     */

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {2, 1, 3, 4};

        int[] res = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    /*-
        Monotonic stack algorithmic

        TC: O(n + m)
        SC: O(n + m)
        where n = nums1.length and m = nums2.length

        optimal when nums2 have larger length
     */
//    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//
//        int[] res = new int[nums1.length];
//        Stack<Integer> nums2Stack = new Stack<>();
//
//        HashMap<Integer, Integer> nums1Map = new HashMap<>();
//
//        // store nums1 value into map
//        for (int i = 0; i < nums1.length; i++) {
//            nums1Map.put(nums1[i], i);
//        }
//
//        for (int i = 0; i < nums2.length; i++) {
//
//            // if stack is not empty and current element i greater than top of stack
//            while (!nums2Stack.isEmpty() && nums2[i] > nums2Stack.peek()) {
//
//                int val = nums2Stack.pop(); // get val at top of stack and pop
//                int index = nums1Map.get(val); // get index in nums1 based on value
//
//                res[index] = nums2[i];
//            }
//
//            // if current element in map then add it to stack to get the next greater element
//            if (nums1Map.containsKey(nums2[i])) {
//                nums2Stack.push(nums2[i]);
//            }
//
//            // if no next greater element then return -1
//            if (i < res.length && res[i] == 0) {
//                res[i] = -1;
//            }
//        }
//        return res;
//    }

    /*-
    Monotonic stack algorithmic

    TC: O(n + m)
    SC: O(n)
    where n = nums1.length and m = nums2.length

    optimal when nums1 and nums2 are similar in length
 */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        Stack<Integer> nums2Stack = new Stack<>();
        HashMap<Integer, Integer> eleNextGreaterMap = new HashMap<>();

        // iterate through nums2
        for (int i = 0; i < nums2.length; i++) {

            // if stack is not empty and current ele is greater than top of stack
            while (!nums2Stack.isEmpty() && nums2[i] > nums2Stack.peek()) {

                eleNextGreaterMap.put(nums2Stack.pop(), nums2[i]); // put ele on top of stack and pop it with its next greater ele
            }

            nums2Stack.push(nums2[i]);
        }

        System.out.println(eleNextGreaterMap);

        // iterate through nums1
        for (int i = 0; i < nums1.length; i++) {

            // get nums1 next greater ele from the map, if no next greater ele, set value to -1
            res[i] = eleNextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return res;
    }

    /*-
        TC: O(m * n)
        SC: (m)
        where m = nums1.length and n = nums2.length
     */
//    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//
//        int[] res = new int[nums1.length];
//        HashMap<Integer, Integer> nums1Map = new HashMap<>();
//
//        for (int i = 0; i < nums1.length; i++) {
//            nums1Map.put(nums1[i], i);
//        }
//
//        for (int i = 0; i < nums2.length; i++) {
//
//            if (nums1Map.containsKey(nums2[i])) {
//
//                for (int j = i + 1; j < nums2.length; j++) {
//
//                    if (nums2[i] < nums2[j]) {
//
//                        int index = nums1Map.get(nums2[i]);
//                        res[index] = nums2[j];
//                        break;
//                    }
//                }
//            }
//
//            if (i < res.length && res[i] == 0) {
//                res[i] = -1;
//            }
//        }
//
//        return res;
//    }
}
