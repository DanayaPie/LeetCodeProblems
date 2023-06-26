package codingProblems.Java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax {

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    /*
        Monotonic queue
        TC: O(n)
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> maxIndexQ = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // remove from last if last element is smaller than current element
            while (!maxIndexQ.isEmpty() && nums[i] > nums[maxIndexQ.peekLast()]) {
                maxIndexQ.pollLast();
            }

            // add current element to queue
            maxIndexQ.add(i);

            // if current element is at the end of the window
            if (i >= k - 1) {

                if (!maxIndexQ.isEmpty() && maxIndexQ.peekFirst() < i - k + 1) {
                    maxIndexQ.pollFirst();
                }
                res[i - k + 1] = nums[maxIndexQ.peekFirst()];
            }
        }

        return res;
    }

    /*
        Brute force -> time out on LeetCode
        TC: O(nk)
     */
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//
//        int[] res = new int[nums.length - k + 1];
//
//        for (int i = 0; i < nums.length; i++) {
//
//            int currentMax = nums[i];
//            int j = i + 1;
//
//            while (j < i + k && j < nums.length) {
//
//                currentMax = Math.max(currentMax, nums[j]);
//                j++;
//            }
//
//            if (i < res.length) {
//                res[i] = currentMax;
//            }
//        }
//
//        return res;
//    }
}
