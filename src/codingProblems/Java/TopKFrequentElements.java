package codingProblems.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums = {1, -1, 1, 2, 2, 1, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    /**
     * HashMap with Bucket Sort
     * TC: O(n) - O(n log n) most case
     * SC: O(n)
     */
    public static int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> bucket[] = new ArrayList[nums.length + 1]; // create bucket with size of input nums

        for (int num : nums) {

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // add key into the corresponding freq in bucket[]
        for (int key : freqMap.keySet()) {

            int freq = freqMap.get(key);
            if (bucket[freq] == null) {

                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        // iterate through bucket in reverse to get top freq eles
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int val : bucket[i]) {

                    res[index++] = val;
                    if (index == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }

    /**
     * HashMap with PriorityQueue (binary heap based DS) - created custom comparator based on frequency using lambda expression
     * TC: O(n log k)
     * SC: O(n) from O(n + k)
     */
//    public static int[] topKFrequent(int[] nums, int k) {
//
//        int[] res = new int[k];
//
//        HashMap<Integer, Integer> freqMap = new HashMap<>();
//        for (int num : nums) {
//            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//        }
//
//        // create PQ with largest freq at the bottom using lambda expression to create custom comparator
//        /*
//            if a - b, return negative value, a have higher priority
//            if a - b, return positive value, b have higher priority
//            if a - b, return 0, priority is determined by the natural order
//
//            - priority = top most element, will get poll() out first
//         */
//        PriorityQueue<Integer> topKFreq = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));
//
//
//        // iterate through freqMap and add ele to topKFreq PQ, if PQ size > k, remove from top (smallest freq)
//        for (int num : freqMap.keySet()) {
//
//            topKFreq.offer(num);
//            if (topKFreq.size() > k) {
//                topKFreq.poll();
//            }
//        }
//
//        // add largest freq from PQ to res while removing it
//        int index = k - 1;
//        while (!topKFreq.isEmpty()) {
//            res[index--] = topKFreq.poll();
//        }
//
//        return res;
//    }

    /**
     * Brute Force
     * TC: O(n * k)
     * SC: O(n)
     */
//    public static int[] topKFrequent(int[] nums, int k) {
//
//        int[] res = new int[k];
//        HashMap<Integer, Integer> freqMap = new HashMap<>();
//
//        for (int num : nums) {
//
//            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//        }
//
//        for (int i = 0; i < k; i++) {
//
//            int maxFreq = 0;
//            int maxFreqEle = 0;
//
//            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
//
//                int ele = entry.getKey();
//                int freq = entry.getValue();
//
//                if (freq > maxFreq) {
//                    maxFreq = freq;
//                    maxFreqEle = ele;
//                }
//            }
//
//            res[i] = maxFreqEle;
//            freqMap.remove(maxFreqEle);
//        }
//
//        return res;
//    }
}
