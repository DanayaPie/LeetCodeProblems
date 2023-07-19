package codingProblems.Java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax {

    public static void main(String[] args) {

        int[] nums = {7,2,4};
        int k = 2;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    /**
     * Sliding Window - Monotonic queue
     * TC: O(n), adding and removing in que is O(1)
     * SC: O(k), but O(n - k + 1) if counting the int[] res
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> maxIndexQ = new ArrayDeque<>();
        int lEnd = 0;

        for (int rEnd = 0; rEnd < nums.length; rEnd++) {

            // if queue is not empty, removes all elements from the LEFT that are less than current element
            while (!maxIndexQ.isEmpty() && nums[rEnd] > nums[maxIndexQ.peekLast()]) {

                maxIndexQ.pollLast();
            }

            maxIndexQ.add(rEnd);

            // if rEnd is equal or larger than right bracket
            if (rEnd >= k - 1) {

                if (!maxIndexQ.isEmpty() && maxIndexQ.peekFirst() < lEnd) {

                    maxIndexQ.pollFirst();
                }

                res[lEnd] = nums[maxIndexQ.peekFirst()];
                lEnd++;
            }
        }

        return res;
    }


    /**
     * Brute force -> time out on LeetCode
     * TC: O(nk)
     */
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//
//        int[] res = new int[nums.length - k + 1];
//
//        for (int i = 0; i < nums.length; i++) {
//
//            int max = nums[i];
//            int j = i + 1;
//
//            while (j < i + k - 1 && j < nums.length) {
//
//                max = Math.max(max, nums[j]);
//                j++;
//            }
//
//            if (i < res.length) {
//                res[i] = max;
//            }
//        }
//
//        return res;
//    }
}
